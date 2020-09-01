package com.bcjd.hanxi.mapper;

import java.util.List;


import com.bcjd.hanxi.pojo.Orders;
import com.bcjd.hanxi.pojo.OrdersExt;
import com.bcjd.hanxi.pojo.OrdersExt2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Repository
public interface OrdersMapper extends tk.mybatis.mapper.common.Mapper<Orders> {
	List<Orders> findOrders();
	List<Orders> findOrdersList(@Param("state") String state);
	List<Orders> selectOrdersAllByTypeAndKey( String type,String key);

	//更新订单
	void updateOrders(@Param("orders") Orders orders);

	List<Orders> selectDealerHisOrdersByCurName(@Param("getDealerId") String getDealerId);

	List<Orders> getOrdersListByIdKey(@Param("getDealerId") String getDealerId , String key);

	//批量删除订单
	void deleteManyOrder(int[] delete);

	//删除单个订单
	void deleteOneOrder(Integer id);

	//获得净利润
	int actualProfit(int id);

	//获得总额
	int sumProfit(int id);

	//获得下单数
	int mySellOrders(int id);

	//插入订单返回操作影响的行数
	int insertOrders(OrdersExt2 orders);

	//查询所有下级代理的出货数量
	int[] lowerProfit(int fatherId);

	//获得订单收货人id的等级
	String showDealerLevel(@Param("id")int id);

	//查询订单是否存在
	Orders checkOrdersById(@Param("id")String id);

	//获得订单
	Orders getOrderbyId(@Param("id")int id);

	//获得经销商对应发送订单
	List selectSendOrdersBystate(int id,String state);

	List<OrdersExt> selectOrdersAndDetail(int id);
}




