package com.bookyue.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookyue.mapper.BookPublishMapper;
import com.bookyue.mapper.OrderInfoMapper;
import com.bookyue.mapper.UserInfoMapper;
import com.bookyue.model.BookPublish;
import com.bookyue.model.OrderInfo;
import com.bookyue.model.OrderInfoCustom;
import com.bookyue.model.OrderInfoExample;
import com.bookyue.model.OrderQueryVo;
import com.bookyue.model.UserInfo;
import com.bookyue.service.OrderInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private BookPublishMapper bookPublishMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public List<OrderInfoCustom> getListByBuyerUserId(Integer buyerUserId) {
		return orderInfoMapper.selectOrderInfoCustomListBuyerUserId(buyerUserId);
	}

	@Override
	public PageInfo<OrderInfoCustom> getOrderInfoCustomList(int pageNum, Integer buyerUserId, Integer sellerUserId,
			Byte status) {

		// buyerUserId,sellerUserId至少一个不为空
		if (buyerUserId != null || sellerUserId != null && pageNum > 0) {
			// 设置分页
			PageHelper.startPage(pageNum, 15);
			// 设置查询条件:买家userId
			OrderInfo orderInfo = new OrderInfo();
			if (buyerUserId != null) {
				orderInfo.setBuyerUserId(buyerUserId);
			}
			// 设置订单状态
			if (status != null && status != 0) {
				orderInfo.setStatus(status);
			}
			if (sellerUserId != null) {
				orderInfo.setSellerUserId(sellerUserId);
			}

			List<OrderInfoCustom> list = orderInfoMapper.selectOrderInfoCustomList(orderInfo);
			PageInfo<OrderInfoCustom> pageInfo = new PageInfo<>(list);
			return pageInfo;
		} else {
			// 返回空的对象
			return null;
		}
	}

	@Transactional
	@Override
	public boolean add(OrderInfo orderInfo) {
		if (orderInfo.getBookId() != null) {
			BookPublish bookPublish = bookPublishMapper.selectByPrimaryKey(orderInfo.getBookId());
			// 书籍存在
			if (bookPublish != null) {
				// 余量大于本次所需数量且 当前买家不为该书的发布者
				if (bookPublish.getBookAmount() >= orderInfo.getBookAmount()
						&& bookPublish.getUserId() != orderInfo.getBuyerUserId()) {
					orderInfo.setBookPrice(bookPublish.getBookSellPrice());
					orderInfo.setBookName(bookPublish.getBookName());
					orderInfo.setBookAuthor(bookPublish.getBookAuthor());
					orderInfo.setBookPublisher(bookPublish.getBookPublisher());
					orderInfo.setBookPicPath(bookPublish.getBookPicPath());
					orderInfo.setBookAuthor(bookPublish.getBookAuthor());
					orderInfo.setSellerUserId(bookPublish.getUserId());
					BigDecimal totalPrice = bookPublish.getBookSellPrice()
							.multiply(BigDecimal.valueOf(orderInfo.getBookAmount()));
					orderInfo.setTotalPrice(totalPrice);

					orderInfo.setStatus((byte) 1);
					orderInfo.setCreateTime(new Date());
					int effectNum = orderInfoMapper.insertSelective(orderInfo);
					// 减去书籍余量
					bookPublish.setBookAmount((short) (bookPublish.getBookAmount() - orderInfo.getBookAmount()));
					int effectNum2 = bookPublishMapper.updateByPrimaryKeySelective(bookPublish);
					if (effectNum == 1 && effectNum2 == 1) {
						return true;
					} else {
						throw new RuntimeException("下订单失败,数据插入失败");
					}
				} else {
					throw new RuntimeException("下订单失败,书籍数量不足或当前买家为发布者");
				}

			} else {
				throw new RuntimeException("下订单失败,没有找到到" + orderInfo.getBookId() + "这本书籍");
			}
		}
		throw new RuntimeException("orderInfo.getBookId() == null");
	}

	@Transactional
	@Override
	public boolean confirmObtained(OrderInfo orderInfo) {
		// 订单id和当前用户id不为空
		if (orderInfo.getId() != null && orderInfo.getBuyerUserId() != null) {

			OrderInfoExample example = new OrderInfoExample();
			example.createCriteria().andIdEqualTo(orderInfo.getId()).andBuyerUserIdEqualTo(orderInfo.getBuyerUserId());
			// 查询用于判断订单是否存在,且状态是否 卖家已发货
			orderInfo = orderInfoMapper.selectByExample(example).get(0);

			// orderInfo = orderInfoMapper.selectByPrimaryKey(orderInfo.getBookId());
			if (orderInfo != null && orderInfo.getStatus() == 2) {
				OrderInfo tempOrderInfo = new OrderInfo();
				// 重置订单id
				tempOrderInfo.setId(orderInfo.getId());
				// 改变订单状态
				tempOrderInfo.setStatus((byte) 3);
				// 设置订单完成时间
				tempOrderInfo.setCompleteTime(new Date());

				return orderInfoMapper.updateByPrimaryKeySelective(tempOrderInfo) == 1 ? true : false;
			}
			return false;
		} else {
			throw new RuntimeException("orderId为null");
		}
	}

	@Override
	public boolean confirmSent(OrderInfo orderInfo) {
		// 订单id和当前用户id不为空
		if (orderInfo.getId() != null && orderInfo.getSellerUserId() != null) {
			OrderInfoExample example = new OrderInfoExample();
			example.createCriteria().andIdEqualTo(orderInfo.getId())
					.andSellerUserIdEqualTo(orderInfo.getSellerUserId());
			// 查询用于判断订单是否存在,且状态是否 卖家已发货
			orderInfo = orderInfoMapper.selectByExample(example).get(0);

			if (orderInfo != null && orderInfo.getStatus() == 1) {
				OrderInfo tempOrderInfo = new OrderInfo();
				// 重置订单id
				tempOrderInfo.setId(orderInfo.getId());
				// 改变订单状态
				tempOrderInfo.setStatus((byte) 2);
				// 设置订单完成时间
				tempOrderInfo.setCompleteTime(new Date());
				return orderInfoMapper.updateByPrimaryKeySelective(tempOrderInfo) == 1 ? true : false;
			}
			return false;
		} else {
			throw new RuntimeException("orderId或SellerUserId为null");
		}
	}

	@Override
	public PageInfo<OrderInfoCustom> getOrderInfoCustomList(int pageNum, Integer userId, Byte status) {
		// buyerUserId,sellerUserId至少一个不为空
		if (userId != null && pageNum != 0) {
			// 设置分页
			PageHelper.startPage(pageNum, 15);
			// 设置查询条件:userId
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setBuyerUserId(userId);
			orderInfo.setSellerUserId(userId);
			// 设置订单状态
			if (status != null && status != 0) {
				orderInfo.setStatus(status);
			}
			List<OrderInfoCustom> list = orderInfoMapper.selectOrderInfoCustomList(orderInfo);

			PageInfo<OrderInfoCustom> pageInfo = new PageInfo<>(list);
			return pageInfo;
		} else {
			// 返回空的对象
			return null;
		}
		// return null;
	}

	@Override
	public PageInfo<OrderInfoCustom> getMyOrderList(int pageNum, Integer userId, Byte status) {
		if (userId != null) {
			OrderQueryVo orderQueryVo = new OrderQueryVo();
			orderQueryVo.setUserId(userId);
			orderQueryVo.setStatus(status);
			PageHelper.startPage(pageNum, 15);
			List<OrderInfoCustom> list = orderInfoMapper.selectAllByOrderQueryVo(orderQueryVo);
			return new PageInfo<OrderInfoCustom>(list);
		} else {
			throw new RuntimeException(this.getClass().getName() + "userId为null");
		}
	}

	@Override
	public PageInfo<OrderInfoCustom> getMyOnTradingOrderList(int pageNum, Integer userId) {
		if (userId != null) {
			PageHelper.startPage(pageNum, 15);
			OrderInfoExample orderInfoExample = new OrderInfoExample();

			List<Byte> statusList = new ArrayList<Byte>();
			statusList.add((byte) 1);
			statusList.add((byte) 2);
			orderInfoExample.createCriteria().andStatusIn(statusList).andSellerUserIdEqualTo(userId);
			orderInfoExample.or().andBuyerUserIdEqualTo(userId);
			List<OrderInfoCustom> list = orderInfoMapper.selectOnTradingOrderListByUserId(userId);
			return new PageInfo<OrderInfoCustom>(list);
		} else {
			throw new RuntimeException(this.getClass().getName() + "userId为null");
		}
	}

	@Transactional
	@Override
	public boolean cancelByBuyer(Integer orderId, Integer userId, Short cancleId) {
		if (orderId != null && userId != null & cancleId != null) {
			OrderInfo checkOderInfo = orderInfoMapper.selectByPrimaryKey(orderId);
			// 确认当前用户为买家
			if (checkOderInfo.getBuyerUserId() == userId) {
				Short orderBookAmount = checkOderInfo.getBookAmount();
				OrderInfo tempOderInfo = new OrderInfo();
				tempOderInfo.setId(checkOderInfo.getId());
				tempOderInfo.setCancleCause(cancleId);
				tempOderInfo.setStatus((byte) 4);
				// 得到书籍信息
				BookPublish bookPublish = bookPublishMapper.selectByPrimaryKey(checkOderInfo.getBookId());
				if (bookPublish != null) {
					// 设置bookId和数量-恢复数量
					BookPublish tempBookPublish = new BookPublish();
					tempBookPublish.setBookId(bookPublish.getBookId());
					tempBookPublish.setBookAmount((short) (bookPublish.getBookAmount() + orderBookAmount));

					int orderInfoMapperEffectNum = orderInfoMapper.updateByPrimaryKeySelective(tempOderInfo);
					int bookPublishMappereffectNum = bookPublishMapper.updateByPrimaryKeySelective(tempBookPublish);
					if (orderInfoMapperEffectNum == 1 && bookPublishMappereffectNum == 1) {
						return true;
					} else {
						throw new RuntimeException("取消订单失败,请稍后重试");
					}
				}
				throw new RuntimeException("取消订单失败,书籍信息不存在,bookId:" + checkOderInfo.getBookId());
			} else {
				throw new RuntimeException("取消订单失败,用户信息不匹配");
			}
		} else {
			throw new RuntimeException("取消订单失败,操作参数不够");
		}
	}

	@Override
	public boolean cancelBySeller(Integer orderId, Integer userId, Short cancleId) {
		if (orderId != null && userId != null & cancleId != null) {
			OrderInfo checkOderInfo = orderInfoMapper.selectByPrimaryKey(orderId);
			// 确认当前用户为买=卖家
			if (checkOderInfo.getSellerUserId() == userId) {
				Short orderBookAmount = checkOderInfo.getBookAmount();
				OrderInfo tempOderInfo = new OrderInfo();
				tempOderInfo.setId(checkOderInfo.getId());
				tempOderInfo.setCancleCause(cancleId);
				tempOderInfo.setStatus((byte) 4);
				// 得到书籍信息
				BookPublish bookPublish = bookPublishMapper.selectByPrimaryKey(checkOderInfo.getBookId());
				if (bookPublish != null) {
					// 设置bookId和数量-恢复数量
					BookPublish tempBookPublish = new BookPublish();
					tempBookPublish.setBookId(bookPublish.getBookId());
					tempBookPublish.setBookAmount((short) (bookPublish.getBookAmount() + orderBookAmount));

					int orderInfoMapperEffectNum = orderInfoMapper.updateByPrimaryKeySelective(tempOderInfo);
					int bookPublishMappereffectNum = bookPublishMapper.updateByPrimaryKeySelective(bookPublish);
					if (orderInfoMapperEffectNum == 1 && bookPublishMappereffectNum == 1) {
						return true;
					} else {
						throw new RuntimeException("取消订单失败,数据库操作失败");
					}
				}
				throw new RuntimeException("取消订单失败,书籍信息不存在,bookId:" + checkOderInfo.getBookId());
			} else {
				throw new RuntimeException("取消订单失败,用户信息不匹配");
			}
		} else {
			throw new RuntimeException("取消订单失败,操作参数不够");
		}
	}

	@Override
	public Integer getMyOnTradingOrderNum(Integer userId) {
		if (userId != null) {
			List<OrderInfoCustom> list = orderInfoMapper.selectOnTradingOrderListByUserId(userId);
			return list.size();
		} else {
			throw new RuntimeException(this.getClass().getName() + "userId为null");
		}
	}

	@Override
	public String getOthersPhone(Integer orderId, Integer currentUserId) {

		OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(orderId);
		if (orderInfo != null) {
			UserInfo userInfo = null;
			// 当前登录用户为买家,需要查询卖家的电话
			if (orderInfo.getBuyerUserId() == currentUserId) {
				userInfo = userInfoMapper.selectByPrimaryKey(orderInfo.getSellerUserId());
				return userInfo.getUserPhone();
			} else if (orderInfo.getSellerUserId() == currentUserId) {
				// 当前未卖家,需要查询买家的电话
				userInfo = userInfoMapper.selectByPrimaryKey(orderInfo.getBuyerUserId());
				return userInfo.getUserPhone();
			}
		}
		return null;
	}

}
