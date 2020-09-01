package com.bcjd.hanxi.service;

import com.bcjd.hanxi.pojo.Dealer;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface DealerService {
    String login(String dealerName, String dealerPassword, HttpSession session);

    String register(String dealerName, String dealerPassword ,String grantCode,HttpSession session);
    //获取授权码
    Map<String,String> getCode(String code);

    int selectDealerCount(Dealer dealer);

    //获取全部经销商的信息
    List<Dealer> selectDealerAll();

    //添加经销商
    String toAddDealer(Dealer dealer);

    //更新经销商信息
    void updateDealer(Dealer dealer);

    List<Dealer> selectDealerAllByTypeAndKey(String type,String key);

    //获取某个经销商下级
    int[]  selectByFatherId(int id);

    //删除单个经销商
    void deleteOneDealer(int id);

    //查询我的个人信息
    Dealer selectMyInfo(int id);

    //修改个人信息
    void updateMyInfo(Dealer dealer);

    //经销商端的添加经销商
    int insertDealer(Dealer dealer);

    //分页
    PageInfo<Dealer> findAllUserByPageS(Dealer dealer, int pageNum, int pageSize);

    //按销售成绩查询下级经销商
    List<Dealer> selectLowerDealer(int id);
}
