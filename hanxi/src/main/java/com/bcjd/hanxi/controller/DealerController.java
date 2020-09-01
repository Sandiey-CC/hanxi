package com.bcjd.hanxi.controller;

import com.bcjd.hanxi.commom.StageManager;
import com.bcjd.hanxi.pojo.Dealer;
import com.bcjd.hanxi.pojo.DealerStockShortDdata;
import com.bcjd.hanxi.service.DealerService;
import com.bcjd.hanxi.service.DealerStockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dealer")
public class DealerController {
    @Autowired
    DealerService dealerService;
    @Autowired
    DealerStockService dealerStockService;

    //时间格式转换局部
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody Dealer dealer,HttpSession session) {
        System.out.println(dealer.getDealerName());
        String result = dealerService.login(dealer.getDealerName(),dealer.getDealerPassword(),session);
        return result;
    }

    @RequestMapping(value = "/getCurDealer")
    public void getCurDealer(HttpServletRequest request , HttpServletResponse response) throws IOException {
        Dealer dealer = (Dealer) request.getSession().getAttribute("curDealer");
        if(dealer!=null){
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(),dealer);
        }
        StageManager.curName.put("curName",dealer);
    }

    @RequestMapping(value = "/clearDealer")
    public void clearDealer(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("curDealer");
    }


    @ResponseBody
    @PostMapping(value = "/register")
    public String register(String dealerName, String dealerPassword ,String grantCode,HttpSession session) {
        System.out.println(grantCode);
        String result = dealerService.register(dealerName,dealerPassword,grantCode,session);
        return result;

    }

    @ResponseBody
    @PostMapping(value = "/generateCode")
    public Map generateCode(String fatherCode) {
        System.out.println(fatherCode);
        Map result = dealerService.getCode(fatherCode);
        return result;

    }

    @RequestMapping("/dealer_count")
    @ResponseBody
    public int dealer_count(Dealer dealer){
        return dealerService.selectDealerCount(dealer);
    }

    @RequestMapping("/dealer_list")
    @ResponseBody
    public List<Dealer> dealer_list(Dealer dealer){
        for (Dealer d:dealerService.selectDealerAll()) {
            System.out.println(d.getRegistTime());
        }
        return dealerService.selectDealerAll();
    }

    @ResponseBody
    @PostMapping(value = "/addDealers")
    public String addDealers(Dealer dealer){
        System.out.println("addDealers:"+dealer);
        String str =  dealerService.toAddDealer(dealer);
        return str;
    }
    @ResponseBody
    @RequestMapping("/updateDealer")
    public String updateDealer( @RequestBody Dealer dealer){
        dealerService.updateDealer(dealer);
        return "修改成功";
    }

    @RequestMapping("/getDealerListByKey")
    @ResponseBody
    public List<Dealer> getDealerListByKey(String type, String key){
        List<Dealer> list = dealerService.selectDealerAllByTypeAndKey(type, key);
        System.out.println(list.size());
        System.out.println(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOneDealer")
    public List<Dealer> deleteOneDealer(@RequestBody Dealer dealer) {
        System.out.println(dealer.getId());
        int[] theDealerMessage1 = dealerService.selectByFatherId(dealer.getId());
        dealerService.deleteOneDealer(dealer.getId());
        if (theDealerMessage1.length>0){
            for (int theDeleteid1 : theDealerMessage1){
                dealerService.deleteOneDealer(theDeleteid1);
                int[] theDealerMessage2 = dealerService.selectByFatherId(theDeleteid1);
                if (theDealerMessage2.length>0){
                    for (int theDeleteid2 : theDealerMessage2){
                        dealerService.deleteOneDealer(theDeleteid2);
                    }
                }
            }
        }
        return  dealerService.selectDealerAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteManyDealer")
    public List<Dealer> deleteManyDealer(int[] delete) {
        for (int xx :delete)
            System.out.println(xx);

        for (int id :delete){
            int[] theDealerMessage1 = dealerService.selectByFatherId(id);
            dealerService.deleteOneDealer(id);
            if (theDealerMessage1.length>0){
                for (int theDeleteid1 : theDealerMessage1){
                    dealerService.deleteOneDealer(theDeleteid1);
                    int[] theDealerMessage2 = dealerService.selectByFatherId(theDeleteid1);
                    if (theDealerMessage2.length>0){
                        for (int theDeleteid2 : theDealerMessage2){
                            dealerService.deleteOneDealer(theDeleteid2);
                        }
                    }
                }
            }
        }

        return  dealerService.selectDealerAll();
    }

    @ResponseBody
    @RequestMapping("/selectMyInfo")
    public Dealer selectMyInfo(@RequestBody Dealer dealer){
        System.out.println("执行了selectMyInfo");
        System.out.println(dealer.getId());
        System.out.println(dealerService.selectMyInfo(dealer.getId()));
        return dealerService.selectMyInfo(dealer.getId());
    }

    @ResponseBody
    @RequestMapping("/updateMyInfo")
    public String updateMyInfo(@RequestBody Dealer dealer){
        dealerService.updateMyInfo(dealer);
        return "修改成功";
    }


    /*作者：高登毅
    * */
    //返回父级经销商库存商品列表
    @ResponseBody
    @RequestMapping(value = "/father_product_list")
    public List<DealerStockShortDdata> getFatherProductList(HttpSession session){
        //从会话中拿到当前用户
        Dealer aDealer = (Dealer) session.getAttribute("curDealer");

        if(aDealer == null) System.out.println("aDealer is null");
        else System.out.println("aDealer is not null");

        System.out.println("当前用户的上级经销商的父级id是"+aDealer.getFatherId());

        for ( DealerStockShortDdata s : dealerStockService.selectAllStockProductsByDealerId(aDealer.getFatherId()))
            System.out.println("当前用户父级的库存是"+s);
        //返回上级的所有库存
        return dealerStockService.selectAllStockProductsByDealerId(aDealer.getFatherId());
    }

    //添加经销商
    @ResponseBody
    @RequestMapping("/addDealer")
    public int addDealer(Dealer dealer){
        System.out.println("addDealer:"+dealer);
        return dealerService.insertDealer(dealer);
    }


    //分页
    @ResponseBody
    @RequestMapping("/testPageHelper1")
    public PageInfo<Dealer> testPageHelper1(Dealer dealer, @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "10") int pageSize){
        PageInfo<Dealer> queryResult = dealerService.findAllUserByPageS(dealer,pageNum,pageSize);
        System.out.println(queryResult);
        return queryResult;
    }

    @ResponseBody
    @RequestMapping("/getLowerDealer")
    public List<Dealer> getLowerDealer(@RequestBody Dealer dealer){
        System.out.println("执行了getLowerDealer");
        System.out.println(dealer.getId());
        return dealerService.selectLowerDealer(dealer.getId());
    }
}
