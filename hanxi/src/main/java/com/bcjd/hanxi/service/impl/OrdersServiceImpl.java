package com.bcjd.hanxi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bcjd.hanxi.mapper.DealerStockMapper;
import com.bcjd.hanxi.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcjd.hanxi.mapper.OrdersMapper;
import com.bcjd.hanxi.service.OrdersService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersMapper ordersMapper;

	@Autowired
	private DealerStockMapper dealerStockMapper;
	@Override
	public void showById() {
		//单表操作,注意主类的mapperscan应导入tk.mybatis....mapperscan
		Orders orders = new Orders();
		
		
		  List<Orders> list1= ordersMapper.findOrders();
		  
		  for (Orders orders1 : list1) {
		  System.out.println("example1:"+orders1.getCreateTime()); }

		 
		
		orders = ordersMapper.selectByPrimaryKey(1);
		System.out.println(orders.getCreateTime());
		System.out.println(orders.getCreateTime().getTime());
		/* select */
		Example example = new Example(orders.getClass());
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id", 1);
		 
		List<Orders> list = ordersMapper.selectByExample(example);
		
		for (Orders orders2 : list) {
			System.out.println("example2:"+orders2.getCreateTime());
		}
		

		}

	@Override
	public List<Orders> findOrdersList(String state) {
		return ordersMapper.findOrdersList(state);
	}

	@Override
	public List<Orders> selectOrdersAllByTypeAndKey(String type, String key) {
		System.out.println("OrdersServiceImpl已执行 and type = " + type);
		return ordersMapper.selectOrdersAllByTypeAndKey(type,key);
	}

	@Override
	public void updateOrders(Orders orders) {
		ordersMapper.updateOrders(orders);
	}

	@Override
	public List<Orders> selectDealerHisOrdersByCurName(String getDealerId) {

		return ordersMapper.selectDealerHisOrdersByCurName(getDealerId);
	}

	@Override
	public List<Orders> getOrdersListByIdKey(String getDealerId, String key) {
		return ordersMapper.getOrdersListByIdKey(getDealerId,key);
	}

	@Override
	public void deleteManyOrder(int[] delete) {
		ordersMapper.deleteManyOrder(delete);
	}

	@Override
	public void deleteOneOrder(Integer id) {
		ordersMapper.deleteOneOrder(id);
	}

	@Override
	public int actualProfit(int id) {
		return ordersMapper.actualProfit(id);
	}

	@Override
	public int sumProfit(int id) {
		return ordersMapper.sumProfit(id);
	}

	@Override
	public int mySellOrders(int id) {
		return ordersMapper.mySellOrders(id);
	}

	//根据进货信息创建订单
	@Override
	public int createOrder(OrdersExt2 orders) {

		orders.setCreateTime(new Date());   //写入订单创建时间
		System.out.println("待插订单是"+orders);
		//在数据库中插入订单
		return 	ordersMapper.insertOrders(orders);

	}

	@Override
	public PageInfo<Orders> findAllOrderByPageS(Orders orders, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Orders> lists = ordersMapper.select(orders);
		PageInfo<Orders> pageInfo = new PageInfo<Orders>(lists);
		return pageInfo;
	}

	@Override
	public int[] lowerProfit(int fatherId) {
		return ordersMapper.lowerProfit(fatherId);
	}

	@Override
	public String getSecurityCode(Orders orders) {
		System.out.println(orders);

		Orders orders1 = ordersMapper.getOrderbyId(orders.getId());


		String Orders_id = String.valueOf(orders1.getId());
		Integer getDealer_id = orders1.getGetDealerId();
		Integer product_id = orders1.getProductId();
		String count = String.valueOf(orders1.getCount());
		System.out.println("执行了OrdersServiceImpl：getSecurityCode()");

		int dealerId = orders1.getGetDealerId();
		System.out.println("DealerId : " + dealerId);

		String level_name = ordersMapper.showDealerLevel(dealerId);

		System.out.println("拿货代理的等级:" + level_name);
		int level = 0;
		if (level_name.equals("一级经销商")){
			level = 1;
		}else if (level_name.equals("二级经销商")){
			level = 2;
		}else{
			level = 3;
		}
		System.out.println("拿货代理的level:" + level);


		String SecurityCode = Orders_id + "A" + getDealer_id + "B" + level + "C" + product_id + "D" + count;
		System.out.println("防伪码" + SecurityCode);
		return SecurityCode;
//		return "123";
	}

	public String checkOrdersById(String Code) {

		String[] strings = Code.split("(?<!^)(?=[A-Z])");
		for (int i = 0; i < strings.length;i++)
			System.out.println(strings[i]);

		Orders orders = ordersMapper.checkOrdersById(strings[0]);
		System.out.println("dealerID " + strings[1].substring(1,strings[1].length()) + orders.getGetDealerId());
		System.out.println("ID " + strings[0] + orders.getId());
		System.out.println("productID " + strings[3].substring(1,strings[3].length()) + orders.getProductId());
		System.out.println("Count " + strings[4].substring(1,strings[4].length()) + orders.getCount());

		if ((orders.getId() == Integer.parseInt(strings[0]))
				&& orders.getGetDealerId()== Integer.parseInt(strings[1].substring(1,strings[1].length()))
				&& orders.getProductId()== Integer.parseInt(strings[3].substring(1,strings[3].length()))
				&& (orders.getCount() == Integer.parseInt(strings[4].substring(1,strings[4].length()))))
		{

			return "该商品防伪码已备案";
		}else{
			return "该商品防伪码不存在！";
		}

//		if (orders == null)
//			return "该商品防伪码不存在！";
//		else
//			return "该商品防伪码已备案";
	}


	@Override
	public List getSendOrders(int id, String state) {
		return ordersMapper.selectSendOrdersBystate(id,state);
	}

	@Override
	public List<OrdersExt> getSendOrdersDetail(int id, int level) {
		if(level==1||level==2)
			return ordersMapper.selectOrdersAndDetail(id);
		return null;
	}

	@Override
	public String commitSendOrders(int ordersId, int dealerId) {
		List<OrdersExt> ordersExt3 = ordersMapper.selectOrdersAndDetail(ordersId);

		List<Integer> proId = new ArrayList<>();
		List<Integer> proCount =new ArrayList<>();

		for(int i = 0; i< ordersExt3.size(); i++){
			if(ordersExt3.get(i).getOrdersDetail()!=null){
				List<OrdersDetail> ordersDetails = ordersExt3.get(i).getOrdersDetail();
				proId.add(ordersDetails.get(0).getDealerStock().getProductId());
				proCount.add(ordersDetails.get(0).getNumber());
			}

		}

		for(int i=0;i<proId.size();i++){
			Example example = new Example(DealerStock.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo("dealerId",dealerId);
			criteria.andEqualTo("id",proId.get(i));
			List<DealerStock> dealerStock  = dealerStockMapper.selectByExample(example);

			if(dealerStock.get(i).getCount()<proCount.get(i))
				return "发货失败，请检查库存量";

			int remain = dealerStock.get(i).getCount()-proCount.get(i);
			DealerStock dealerStock1 = new DealerStock();
			dealerStock1.setCount(remain);
			dealerStockMapper.updateByExampleSelective(dealerStock1,example);
			Orders orders = new Orders();
			orders.setState("已发货");
			orders.setCompleteTime(new Date());
			Example example1 = new Example(Orders.class);
			Example.Criteria criteria1= example1.createCriteria();
			criteria1.andEqualTo("id",ordersId);
			ordersMapper.updateByExampleSelective(orders,example1);
			return "发货成功";
		}

		return "发货失败";
	}

}
