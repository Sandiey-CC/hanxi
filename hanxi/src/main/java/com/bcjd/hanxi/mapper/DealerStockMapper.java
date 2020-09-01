package com.bcjd.hanxi.mapper;

import com.bcjd.hanxi.pojo.DealerStock;
import com.bcjd.hanxi.pojo.DealerStockShortDdata;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Repository
public interface DealerStockMapper extends tk.mybatis.mapper.common.Mapper<DealerStock> {

    // 指定经销商id，将库存表与产品表做自然连结 查询该经销商的所有库存
    List<DealerStockShortDdata> selectAllStockProductsByDealerId(String Dealerid);

    //指定仓库id 更新该仓库商品库存为 newProductCount 更改更新时间
    int updateStockCountById(@Param("id")int stockID , @Param("newCount") int newProductCount , @Param("updateTime") Date updateTime);

}




