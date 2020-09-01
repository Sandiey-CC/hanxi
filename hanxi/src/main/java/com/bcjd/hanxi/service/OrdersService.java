package com.bcjd.hanxi.service;


import com.bcjd.hanxi.pojo.Orders;
import com.bcjd.hanxi.pojo.OrdersExt;
import com.bcjd.hanxi.pojo.OrdersExt2;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrdersService {
	public void showById();
	public List<Orders> findOrdersList(String state);
	public List<Orders> selectOrdersAllByTypeAndKey(String type,String key);

	//更新订单
	public void updateOrders(Orders orders);

	List<Orders> selectDealerHisOrdersByCurName(String getDealerId);

	List<Orders> getOrdersListByIdKey(String getDealerId, String key);

	//批量删除订单
	void deleteManyOrder(int[] delete);

	//删除单个订单
	void deleteOneOrder(Integer id);

	//计算净利润
	int actualProfit(int id);

	//获得总额
	int sumProfit(int id);

	//获得下单数
	int mySellOrders(int id);

	//根据进货信息，创建订单
	int createOrder(OrdersExt2 orders );

	//分页
	PageInfo<Orders> findAllOrderByPageS(Orders orders, int pageNum, int pageSize);

	//查询所有下级代理的出货数量
	int[] lowerProfit(int fatherId);

	//获取防伪码
	String getSecurityCode(Orders orders);

	//判断防伪码
	String checkOrdersById(String id);

	List getSendOrders(int id,String state);

	List<OrdersExt> getSendOrdersDetail(int id, int level);
	String commitSendOrders(int ordersId,int dealerId);
}
