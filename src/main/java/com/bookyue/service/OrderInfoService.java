package com.bookyue.service;

import java.util.List;

import com.bookyue.model.OrderInfo;
import com.bookyue.model.OrderInfoCustom;
import com.github.pagehelper.PageInfo;

public interface OrderInfoService {

	/**
	 * 通过用户id来查询订单记录
	 * @param buyerUserId
	 * @return
	 */
	List<OrderInfoCustom> getListByBuyerUserId(Integer buyerUserId);

	/**
	 * 添加订单记录
	 * @param orderInfo
	 * @return
	 */
	boolean add(OrderInfo orderInfo);

	/**
	 * 通过购买者的userId,status来查询订单列表
	 * @param pageNum   目标页
	 * @param buyerUserId 购买者的userId
	 * @return
	 */
	PageInfo<OrderInfoCustom> getOrderInfoCustomList(int pageNum, Integer buyerUserId, Integer sellerUserId,
			Byte status);

	/**
	 * 通过userId,status来查询订单列表
	 * @param pageNum 目标页
	 * @param userId 
	 * @param status
	 * @return
	 */
	PageInfo<OrderInfoCustom> getOrderInfoCustomList(int pageNum, Integer userId, Byte status);

	/**
	 * 查询指定userId,status的订单集合<br>
	 * status可以为null<br>
	 * @param pageNum
	 * @param userId
	 * @param status
	 * @return
	 */
	PageInfo<OrderInfoCustom> getMyOrderList(int pageNum, Integer userId, Byte status);

	/**
	 * 根据userId获得该用户在交易订单
	 * @param pageNum
	 * @param userId
	 * @return
	 */
	PageInfo<OrderInfoCustom> getMyOnTradingOrderList(int pageNum, Integer userId);
	
	/**
	 * 获取userId的用户在交易订单的数量
	 * @param userId
	 * @return
	 */
	Integer getMyOnTradingOrderNum(Integer userId);

	/**
	 * 确认收货
	 * 更改订单状态为3
	 * @param orderInfo
	 * @return
	 */
	boolean confirmObtained(OrderInfo orderInfo);

	/**
	 * 卖家确认已送货
	 * 更改订单状态为2
	 * @param orderInfo
	 * @return
	 */
	boolean confirmSent(OrderInfo orderInfo);

	/**
	 * 买家取消订单
	 * @param orderInfo
	 * @return
	 */
	boolean cancelByBuyer(Integer orderId, Integer userId, Short cancleId);

	/**
	 * 卖家取消订单
	 * @param orderInfo
	 * @return
	 */
	boolean cancelBySeller(Integer orderId, Integer userId, Short cancleId);
	
	/**
	 * 获得本次订单对方的手机号
	 * @param currentUserId
	 * @return
	 */
	String getOthersPhone(Integer orderId, Integer currentUserId);
}
