package com.bcjd.hanxi;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.bcjd.hanxi.mapper.OrdersMapper;
import com.bcjd.hanxi.pojo.Orders;
import com.bcjd.hanxi.service.OrdersService;


@SpringBootTest
public class TestApplication {

    /* 通过注解sql语句执行查询
     * @Autowired private OrdersMapper ordersMapper;
     *
     * @Test public void showById() { Orders orders = new Orders(); List<Orders>
     * list = ordersMapper.selectOrder(); for (Orders order : list) {
     * System.out.println(order.getId()); System.out.println(order.getCreateTime());
     * } }
     */
    //通过mybatis的criteria，example等执行查询
    @Autowired
    OrdersService service;

    @Test
    public void showById() {

        service.showById();
    }
}
