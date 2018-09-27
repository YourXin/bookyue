package com.bookyue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bookyue.model.OrderInfo;
import com.bookyue.model.OrderInfoCustom;
import com.bookyue.model.OrderInfoExample;
import com.bookyue.model.OrderQueryVo;

public interface OrderInfoMapper {
	long countByExample(OrderInfoExample example);

	int deleteByExample(OrderInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(OrderInfo record);

	int insertSelective(OrderInfo record);

	List<OrderInfo> selectByExample(OrderInfoExample example);

	OrderInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

	int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

	int updateByPrimaryKeySelective(OrderInfo record);

	int updateByPrimaryKey(OrderInfo record);

	List<OrderInfoCustom> selectOrderInfoCustomListBuyerUserId(Integer userId);

	/**
	 * 可设置buyerUserId和status参数,其余设置无效
	 * @param orderInfo
	 * @return
	 */
	List<OrderInfoCustom> selectOrderInfoCustomList(OrderInfo orderInfo);

	List<OrderInfoCustom> selectCustomListByExample(OrderInfoExample example);

	/**
	 * 可设置userId和status参数,其余设置无效
	 * @param orderInfo
	 * @return
	 */
	List<OrderInfoCustom> selectAllByOrderQueryVo(OrderQueryVo orderQueryVo);

	List<OrderInfoCustom> selectOnTradingOrderListByUserId(Integer userId);
}