package com.bcjd.hanxi.service.impl;



import com.bcjd.hanxi.mapper.DealerStockMapper;
import com.bcjd.hanxi.pojo.DealerStockShortDdata;
import com.bcjd.hanxi.service.DealerStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DealerStockServiceImpl implements DealerStockService {

    @Autowired
    DealerStockMapper dealerStockMapper;

    @Override
    public List<DealerStockShortDdata> selectAllStockProductsByDealerId(String dealerId) {
        return dealerStockMapper.selectAllStockProductsByDealerId(dealerId);
    }

    @Override
    public int updateStockCountById(int stockID, int newProductCount) {
        return   dealerStockMapper.updateStockCountById(stockID,newProductCount,new Date());
    }


}
