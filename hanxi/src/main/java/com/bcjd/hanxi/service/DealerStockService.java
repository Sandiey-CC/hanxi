package com.bcjd.hanxi.service;

import com.bcjd.hanxi.pojo.DealerStockShortDdata;

import java.util.List;

/*
作者： 高登毅
经销商库存服务
* */
public interface DealerStockService {

    // 指定经销商id，将库存表与产品表做自然连结 查询该经销商的所有库存
    List<DealerStockShortDdata>  selectAllStockProductsByDealerId(String Dealerid);

    //根据货源仓库id更新的商品库存为newProductCount
    int updateStockCountById(int stockID, int newProductCount);
}
