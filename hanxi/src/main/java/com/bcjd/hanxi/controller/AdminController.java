package com.bcjd.hanxi.controller;

import com.bcjd.hanxi.pojo.Admin;
import com.bcjd.hanxi.pojo.Dealer;
import com.bcjd.hanxi.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody Admin admin, HttpSession session) {
        String result = adminService.login(admin.getAdminName(),admin.getAdminPassword(),session);
        return result;
    }
    @ResponseBody
    @PostMapping(value="/register")
    public String register(String adminName, String adminPassword,HttpSession session) {
        String result = adminService.register(adminName,adminPassword,session);
        return result;
    }

    @RequestMapping(value = "/getCurAdmin")
    public void getCurAdmin(HttpServletRequest request , HttpServletResponse response) throws IOException {
        Admin admin = (Admin) request.getSession().getAttribute("curAdmin");
        if(admin!=null){
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(),admin);
        }
    }

    @RequestMapping(value = "/clearAdmin")
    public void clearAdmin(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("curAdmin");
    }


    @RequestMapping("/admin_count")
    @ResponseBody
    public int admin_count(Admin admin){
        return adminService.selectAdminCount(admin);
    }

    @RequestMapping("/admin_list")
    @ResponseBody
    public List<Admin> admin_list(){
        return adminService.selectAdminAll();
    }

    @RequestMapping("/getAdminListByKey")
    @ResponseBody
    public List<Admin> getAdminListByKey(String type,String key){
        List<Admin> list = adminService.selectAdminAllByTypeAndKey(type, key);
        System.out.println(list.size());
        System.out.println(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAllAdmin",method = RequestMethod.POST)
    public List<Admin> deleteAllAdmin(int[] delete) {
        adminService.deleteAllAdmin(delete);
        return adminService.selectAdminAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOneAdmin")
    public List<Admin> deleteOneAdmin(@RequestBody Admin admin) {
        adminService.deleteOneAdmin(admin.getId());
        return adminService.selectAdminAll();
    }
    @ResponseBody
    @RequestMapping("/updateAdmin")
    public String updateAdmin(@RequestBody Admin admin){
        System.out.println(admin.getAdminPassword());
        System.out.println(admin);
        adminService.updateAdmin(admin);
        return "修改成功";
    }

    //分页
    @ResponseBody
    @RequestMapping("/adminPageHelper")
    public PageInfo<Admin> testPageHelper1(Admin admin, @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize){
        PageInfo<Admin> queryResult = adminService.findAllAdminByPageS(admin,pageNum,pageSize);
        System.out.println(queryResult);
        return queryResult;
    }
}
