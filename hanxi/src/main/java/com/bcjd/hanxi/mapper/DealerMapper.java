package com.bcjd.hanxi.mapper;

import com.bcjd.hanxi.pojo.Dealer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Repository
public interface DealerMapper extends tk.mybatis.mapper.common.Mapper<Dealer> {
        List<Dealer> selectDealerAllByTypeAndKey(String type, String key);

        //获取全部经销商的信息
        List<Dealer> selectDealeAll();

        //获取某个经销商下级
        int[]  selectByFatherId(int id);

        //删除单个经销商
        void deleteOneDealer(int id);

        //更新经销商信息
         void updateDealer(@Param("dealer") Dealer dealer);
        //找到当前经销商的上级id
        Integer selectFatherId(String code);

        //查询我的个人信息
        Dealer selectMyInfo(int id);

        //修改个人信息
        void updateMyInfo(@Param("dealer") Dealer dealer);

        //按销售成绩查询下级经销商
        List<Dealer> selectLowerDealer(int id);
}




