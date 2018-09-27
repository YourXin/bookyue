package com.bookyue.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.mapper.UserRedis;
import com.bookyue.model.OrderInfo;
import com.bookyue.model.OrderInfoCustom;
import com.bookyue.service.OrderInfoService;
import com.bookyue.util.MyStringUtil;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/order")
public class OrderInfoController {

	private static Logger logger = LoggerFactory.getLogger(OrderInfoController.class);

	@Autowired
	private OrderInfoService orderInfoService;

	@Autowired
	private UserRedis userRedis;

	private Map<String, Object> map = new HashMap<String, Object>();

	@PostMapping("/save")
	public Map<String, Object> save(@RequestBody OrderInfo orderInfo, @RequestHeader("sessionId") String sessionId) {
		orderInfo.setBuyerUserId(userRedis.getUserId(sessionId));

		map.put("success", orderInfoService.add(orderInfo));
		return map;

	}

	@GetMapping("/getMyOrder")
	public Map<String, Object> getByBuyerUserId(int pageNum, Integer sellerUserId, Byte status,
			@RequestHeader("sessionId") String sessionId) {
		Integer buyerUserId = userRedis.getUserId(sessionId);

		PageInfo<OrderInfoCustom> pageInfo = orderInfoService.getOrderInfoCustomList(pageNum, buyerUserId, sellerUserId,
				status);
		if (pageInfo != null) {
			map.put("success", true);
			map.put("pageInfo", pageInfo);
			map.put("hasNextPage", pageInfo.isHasNextPage());
			map.put("nextPage", pageInfo.getNextPage());
			map.put("list", pageInfo.getList());
		} else {
			map.put("success", false);
		}
		return map;
	}

	@GetMapping("/getMyBoughtOrder")
	public Map<String, Object> getMyBoughtOrder(int pageNum, @RequestHeader("sessionId") String sessionId) {
		Integer buyerUserId = userRedis.getUserId(sessionId);

		PageInfo<OrderInfoCustom> pageInfo = orderInfoService.getOrderInfoCustomList(pageNum, buyerUserId, null,
				(byte) 3);
		if (pageInfo != null) {
			map.put("success", true);
			map.put("pageInfo", pageInfo);
			map.put("hasNextPage", pageInfo.isHasNextPage());
			map.put("nextPage", pageInfo.getNextPage());
			map.put("list", pageInfo.getList());
		} else {
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 查询全部订单
	 * @param pageNum
	 * @param userId
	 * @param status
	 * @return
	 */
	@GetMapping("/getMyAllOrder")
	public Map<String, Object> getMyAllOrder(int pageNum, @RequestHeader("sessionId") String sessionId) {
		Integer userId = userRedis.getUserId(sessionId);
		map.put("pageInfo", orderInfoService.getMyOrderList(pageNum, userId, null));
		return map;
	}

	/**
	 * 在交易订单
	 * @param pageNum
	 * @param sessionId
	 * @return
	 */
	@GetMapping("/getMyOnTradingOrder")
	public Map<String, Object> getMyOnTradingOrder(int pageNum, @RequestHeader("sessionId") String sessionId) {
		logger.debug(pageNum + sessionId);
		Integer userId = userRedis.getUserId(sessionId);
		map.put("pageInfo", orderInfoService.getMyOnTradingOrderList(pageNum, userId));
		return map;
	}

	/**
	 * 获得在交易订单数量  Integer userId
	 * @param userId
	 * @return
	 */
	@GetMapping("/getMyOnTradingOrderNum")
	public Map<String, Object> getMyOnTradingOrderNum(@RequestHeader("sessionId") String sessionId) {
		Integer userId = userRedis.getUserId(sessionId);
		Map<String, Object> map = new HashMap<String, Object>();
		Integer num = orderInfoService.getMyOnTradingOrderNum(userId);
		if (num != 0) {
			map.put("success", true);
			map.put("num", num);
			return map;
		}
		map.put("success", false);
		return map;
	}

	/**
	 * 用于我卖出的订单查询
	 * @param pageNum
	 * @param sellerUserId 卖家
	 * @param status
	 * @return
	 */
	@GetMapping("/getMySoldOrder")
	public Map<String, Object> getMySoldOrder(int pageNum, Byte status, @RequestHeader("sessionId") String sessionId) {
		Integer sellerUserId = userRedis.getUserId(sessionId);

		PageInfo<OrderInfoCustom> pageInfo = orderInfoService.getOrderInfoCustomList(pageNum, null, sellerUserId,
				(byte) 3);
		if (pageInfo != null) {
			map.put("success", true);
			map.put("pageInfo", pageInfo);

		} else {
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 买家确认收货
	 * @param orderInfo
	 * @return
	 */
	@PostMapping("/confirmObtain")
	public Map<String, Object> confirmObtain(@RequestBody OrderInfo orderInfo,
			@RequestHeader("sessionId") String sessionId) {
		logger.debug((orderInfo == null) + "");
		logger.debug(orderInfo.getId() + "");

		orderInfo.setBuyerUserId(userRedis.getUserId(sessionId));

		map.put("success", orderInfoService.confirmObtained(orderInfo));
		return map;
	}

	/**
	 * 卖家已送货
	 * @param orderInfo
	 * @return
	 */
	@PostMapping("/confirmSend")
	public Map<String, Object> confirmSend(@RequestBody OrderInfo orderInfo,
			@RequestHeader("sessionId") String sessionId) {

		orderInfo.setSellerUserId(userRedis.getUserId(sessionId));

		map.put("success", orderInfoService.confirmSent(orderInfo));
		return map;
	}

	// 买家取消订单
	@PostMapping("/buyerCancel")
	public Map<String, Object> cancelOrder(@RequestParam("orderId") Integer orderId,
			@RequestParam("cancleId") Short cancleId, @RequestHeader("sessionId") String sessionId) {
		Integer userId = userRedis.getUserId(sessionId);

		logger.debug(orderId + "," + orderId + "," + cancleId);
		map.put("success", orderInfoService.cancelByBuyer(orderId, userId, cancleId));
		return map;
	}

	// 卖家取消订单
	@PostMapping("/sellerCancel")
	public Map<String, Object> sellerCancle(@RequestParam("orderId") Integer orderId,
			@RequestParam("cancleId") Short cancleId, @RequestHeader("sessionId") String sessionId) {
		logger.debug(orderId + "," + orderId + "," + cancleId);
		Integer userId = userRedis.getUserId(sessionId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", orderInfoService.cancelBySeller(orderId, userId, cancleId));
		return map;
	}

	/**
	 * 获得用户当前订单的 另一方电话号码
	 * <p>1. 当前为卖家,返回买家电话</p>
	 * <p>2. 当前为买家,返回卖家电话</p>
	 * @param orderId
	 * @param sessionId
	 * @return
	 */
	@GetMapping("/getOthersPhone")
	public Map<String, Object> getPhone(@RequestParam("orderId") Integer orderId,
			@RequestHeader("sessionId") String sessionId) {
		Integer userId = userRedis.getUserId(sessionId);
		String phone = orderInfoService.getOthersPhone(orderId, userId);
		if (!MyStringUtil.isEmpty(phone)) {
			map.put("success", true);
			map.put("msg", "获取成功");
			map.put("phone", phone);
		} else {
			map.put("success", false);
			map.put("msg", "对方手机号异常");
			map.put("phone", phone);
		}
		return map;
	}
}
