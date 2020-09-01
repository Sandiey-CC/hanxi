package com.bcjd.hanxi.service.impl;

import com.bcjd.hanxi.commom.Validate;
import com.bcjd.hanxi.commom.VerifyMsg;
import com.bcjd.hanxi.mapper.DealerMapper;
import com.bcjd.hanxi.pojo.Dealer;
import com.bcjd.hanxi.service.DealerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DealerServiceImpl implements DealerService {
    @Autowired
    DealerMapper dealerMapper;
    @Override
    public String login(String dealerName, String dealerPassword, HttpSession session) {
        Example example = new Example(Dealer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("dealerName", dealerName);
        List<Dealer> existDealer = dealerMapper.selectByExample(example);

        if(existDealer.size() == 0)
            return "用户名不存在";
        if(existDealer.get(0).getDealerPassword().equals(dealerPassword)){
            session.setAttribute("curDealer",existDealer.get(0));
            return "登录成功";
        }
        else{
            return "密码错误";
        }
    }

    @Override
    public String register(String dealerName, String dealerPassword,String grantCode, HttpSession session) {
        Example example = new Example(Dealer.class);
        Example.Criteria criteria = example.createCriteria();
        if (!VerifyMsg.checkPassword(dealerPassword)) {
            return "密码首字母为大写，且不可重复";
        }
        if (!VerifyMsg.checkUsername(dealerName)) {
            return "用户名以字母开头，由数字和字母组成";
        }
        if (!VerifyMsg.nameIsFormal(dealerName)) {
            return "用户名长度不符合规范，长度为3-10";
        }
        if (!VerifyMsg.passwordIsFormal(dealerPassword)) {
            return "密码长度不符合规范，长度为8-16";
        }
        if (VerifyMsg.dirtyWords(dealerName)) {
            return "含有敏感词汇，请重新输入用户名";
        }
        int level = Validate.getInstance().getLevel(grantCode);
        if(!Validate.getInstance().isValid(grantCode,level))
            return "授权码无效，请重新尝试";

        Dealer dealer = new Dealer();
        dealer.setDealerName(dealerName);
        dealer.setDealerPassword(dealerPassword);
        dealer.setGrantCode(grantCode);
        if(level==1)
            dealer.setLevelName("一级经销商");
        if(level==2)
            dealer.setLevelName("二级经销商");
        if(level==3)
            dealer.setLevelName("三级经销商");
        dealer.setLevel(level);
        dealer.setFatherId(String.valueOf(dealerMapper.selectFatherId(grantCode.substring(grantCode.indexOf("-")+1))));
        dealer.setRegistTime(new Date());


        criteria.andEqualTo("dealerName", dealerName);
        int count = dealerMapper.selectCountByExample(example);
        if (count != 0)
            return "用户名已注册";
        else
            dealerMapper.insertSelective(dealer);

        List<Dealer> existDealer = dealerMapper.selectByExample(example);
        if (existDealer.get(0) != null) {
            session.setAttribute("curDealer", existDealer.get(0));
            return "注册成功";
        }
        return "注册失败";
    }

    @Override
    public Map getCode(String code) {
        Map<String,String> result = new HashMap<>();
        //找不到一个’-‘，即为一级授权码
        int level = Validate.getInstance().getLevel(code);
        String newCode = null;
        if(level==1){
            newCode = Validate.getInstance().addMediuCode(code);
        }
        else if(level==2){
            newCode = Validate.getInstance().addLowerCode(code);
        }else{
            result.put("msg","抱歉！您没有权限");
            return result;
        }
        if(newCode!=null){
            result.put("code",newCode);
            result.put("msg","生成授权码成功");
        }else{
            result.put("msg","系统繁忙，请稍后再试！");
        }
        return result;
    }

    @Override
    public int selectDealerCount(Dealer dealer) {
        return dealerMapper.selectCount(dealer);
    }

    @Override
    public List<Dealer> selectDealerAll() {
        return dealerMapper.selectAll();
    }

    @Override
    public String toAddDealer(Dealer dealer) {
        System.out.println("---in AddDealer---");
        VerifyMsg verifyMsg = new VerifyMsg();
        //获得当前时间并设置到dealer对象中
        Date registerTime = new Date();
        dealer.setRegistTime(registerTime);
        if(verifyMsg.dirtyWords(dealer.getDealerName()))
            return "用户名非法";
        if (verifyMsg.checkPassword(dealer.getDealerPassword()))
            return "密码非法";
        if (!verifyMsg.checkPhoneNum(dealer.getPhone()))
            return "手机号码非法";

        Example example = new Example(Dealer.class);
        Example.Criteria criteria = example.createCriteria();
        //criteria.andEqualTo("fatherId", dealer.getFatherId());
        criteria.andEqualTo("grantCode", dealer.getGrantCode());
        System.out.println("fatherCode"+dealer.getGrantCode());
        List<Dealer>list1 = dealerMapper.selectByExample(example);
        //查看是否存在该经销商

        if (list1.isEmpty())
            return "上级经销商非法";

        String fatherId = list1.get(0).getId().toString();
        int i = dealerMapper.insertSelective(dealer);
        List<Dealer>list2 = dealerMapper.selectByExample(example);
        int dealerId = list2.get(1).getId();
        dealer.setFatherId(fatherId);
        String dealerCode = (dealer.getGrantCode()+"."+Integer.toString(dealerId));
        dealer.setGrantCode(dealerCode);
        dealer.setId(dealerId);
        dealerMapper.updateByPrimaryKeySelective(dealer);
        return "true";
    }

    @Override
    public void updateDealer(Dealer dealer) {
        dealerMapper.updateDealer(dealer);
    }

    @Override
    public List<Dealer> selectDealerAllByTypeAndKey(String type, String key) {
        return dealerMapper.selectDealerAllByTypeAndKey(type, key);
    }

    @Override
    public int[] selectByFatherId(int id) {
        return dealerMapper.selectByFatherId(id);
    }

    @Override
    public void deleteOneDealer(int id) {
        dealerMapper.deleteOneDealer(id);
    }

    @Override
    public Dealer selectMyInfo(int id) {
        return dealerMapper.selectMyInfo(id);
    }

    @Override
    public void updateMyInfo(Dealer dealer) {
        dealerMapper.updateMyInfo(dealer);
    }


    @Override
    public int insertDealer(Dealer dealer) {
        List<Dealer> dealer1 = dealerMapper.select(dealer);
        if (dealer1==null)
            return dealerMapper.insertSelective(dealer);
        else
            return 0;
    }

    //分页查询方法
    @Override
    public PageInfo<Dealer> findAllUserByPageS(Dealer dealer, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Dealer> lists = dealerMapper.select(dealer);
        PageInfo<Dealer> pageInfo = new PageInfo<Dealer>(lists);
        return pageInfo;
    }

    @Override
    public List<Dealer> selectLowerDealer(int id) {
        return dealerMapper.selectLowerDealer(id);
    }
}

