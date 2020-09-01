package com.bcjd.hanxi.controller;

import com.bcjd.hanxi.commom.StageManager;
import com.bcjd.hanxi.pojo.Dealer;
import com.bcjd.hanxi.pojo.Orders;
import com.bcjd.hanxi.pojo.OrdersExt;
import com.bcjd.hanxi.pojo.OrdersExt2;
import com.bcjd.hanxi.service.DealerStockService;
import com.bcjd.hanxi.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
@RequestMapping("/orders")
@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private DealerStockService dealerStockService;

    @RequestMapping("/getOrdersList")
    public List<Orders>getOrdersList(String state) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Orders orders:ordersService.findOrdersList(state)) {
            orders.setCreateTime(sdf.parse(sdf.format(orders.getCreateTime())));
//            System.out.println();
        }
        return ordersService.findOrdersList(state);
    }

    @RequestMapping("/getOrdersListByKey")
    @ResponseBody
    public List<Orders> getOrdersListByKey(String type, String key){
        System.out.println("type:" + type + "key:" + key);
        List<Orders> list = ordersService.selectOrdersAllByTypeAndKey(type, key);
        System.out.println("list的大小为：" +list.size());
        System.out.println("list：" +list);
        return list;
    }

    @RequestMapping("/dealerHisOrders")
    @ResponseBody
    public List<Orders> dealerHisOrders() {

        Dealer dealer = (Dealer) StageManager.curName.get("curName");
        String getDealerId = String.valueOf(dealer.getId());
        System.out.println("curName:" + getDealerId );

        List<Orders> list = ordersService.selectDealerHisOrdersByCurName(getDealerId);
        System.out.println("list的大小为：" +list.size());
        System.out.println("list：" +list);
        return list;
    }

    @RequestMapping("/getOrdersListByIdKey")
    @ResponseBody
    public List<Orders> getOrdersListByIdKey(String key) {

        Dealer dealer = (Dealer) StageManager.curName.get("curName");
        String getDealerId = String.valueOf(dealer.getId());
        System.out.println("curName:" + getDealerId );

        List<Orders> list = ordersService.getOrdersListByIdKey(getDealerId,key);
        System.out.println("list的大小为：" +list.size());
        System.out.println("list：" +list);
        return list;
    }

    @RequestMapping("/updateOrders")
    public String updateOrders(@RequestBody Orders orders){
        System.out.println(orders);
        ordersService.updateOrders(orders);
        return "修改成功";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteManyOrder",method = RequestMethod.POST)
    public List<Orders> deleteManyOrder(int[] delete,String state) throws ParseException {
        ordersService.deleteManyOrder(delete);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Orders theorders:ordersService.findOrdersList(state)) {
            theorders.setCreateTime(sdf.parse(sdf.format(theorders.getCreateTime())));
        }
        return ordersService.findOrdersList(state);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOneOrder")
    public List<Orders> deleteOneOrder(@RequestBody Orders orders) throws ParseException {
        ordersService.deleteOneOrder(orders.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Orders theorders:ordersService.findOrdersList(orders.getState())) {
            theorders.setCreateTime(sdf.parse(sdf.format(theorders.getCreateTime())));
        }
        return ordersService.findOrdersList(orders.getState());
    }

    @RequestMapping("/getProfit")
    public int[] getactuAlProfit(@RequestBody Dealer dealer){
        System.out.println("执行了getProfit");
        System.out.println(dealer.getId());
        int actualProfit = ordersService.actualProfit(dealer.getId());
        int sumProfit = ordersService.sumProfit(dealer.getId());
        int mySellOrders = ordersService.mySellOrders(dealer.getId());
        int [] result = {actualProfit,sumProfit,mySellOrders};
        return result;
    }

    @RequestMapping("/createOrders")
    /*作者 ： 高登毅
    下级经销商点击进货页面dealer_add_product2.html下单按钮创建新的订单
    */
    public int createOreders(@RequestBody OrdersExt2 orders, HttpSession httpSession){
        System.out.println("在创建订单");

        //System.out.println("订单商品名称是"+ordersExt.getProduct().getProductName());


        //修改要上级货源库存数量
        dealerStockService.updateStockCountById(orders.getDealerStockId(),orders.getNewDealerStockProductCount());

        System.out.println("订单是"+orders);
        //接下来就插入订单
        return  ordersService.createOrder(orders);
    }

    @ResponseBody
    @RequestMapping(value = "/showSecurityCode")
    public String showSecurityCode(@RequestBody Orders orders) {
        System.out.println("执行了showSecurityCode");
//        System.out.println("orders: " + orders.getId());
        System.out.println(orders);
        String SecurityCode = ordersService.getSecurityCode(orders);
        return SecurityCode;
    }

    @ResponseBody
    @RequestMapping(value = "/checkSecurityCode")
    public String[] checkSecurityCode(@RequestBody HashMap<String, String> map) {
        System.out.println("执行了checkSecurityCode");

        System.out.println(map.get("Code"));
        String Code = map.get("Code");
//        String[] strings = Code.split("(?<!^)(?=[A-Z])");
//
//        for (int i = 0; i < strings.length;i++)
//            System.out.println(strings[i]);

        String Security = ordersService.checkOrdersById(Code);

        String[] result = new String[2];
        result[0] = Security;

        return result;
    }

    //分页
    @ResponseBody
    @RequestMapping("/PageHelper")
    public PageInfo<Orders> testPageHelper1(Orders orders, @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "10") int pageSize){
        PageInfo<Orders> queryResult = ordersService.findAllOrderByPageS(orders,pageNum,pageSize);
        System.out.println(queryResult);
        return queryResult;
    }

    @RequestMapping("/getLowerProfit")
    public int[] getLowerProfit(@RequestBody Dealer dealer){
        System.out.println(dealer.getId());
        System.out.println("执行了getLowerProfit");
        return ordersService.lowerProfit(dealer.getId());
    }


    @RequestMapping("/getSendOrders")
    public List getSendOrders(int id,String state){
        return ordersService.getSendOrders(id,state);
    }

    @RequestMapping("/getSendOrdersDetail")
    public List<OrdersExt> getSendOrdersDetail(int id, int level){
        List<OrdersExt> ordersExt3 = ordersService.getSendOrdersDetail(id,level);
        System.out.println(id);
        return ordersExt3;
    }

    @ResponseBody
    @PostMapping(value = "/commitSendOrders")
    public String commitSendOrders(int ordersId, int dealerId) {
        return ordersService.commitSendOrders(ordersId,dealerId);

    }
}
