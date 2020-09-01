package com.bcjd.hanxi.service.impl;

import com.bcjd.hanxi.commom.VerifyMsg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.bcjd.hanxi.mapper.AdminMapper;
import com.bcjd.hanxi.pojo.Admin;
import com.bcjd.hanxi.service.AdminService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public String login(String adminName, String adminPassword, HttpSession session) {
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("adminName", adminName);
        List<Admin> existAdmin = adminMapper.selectByExample(example);

        if (existAdmin.size() == 0)
            return "用户名不存在";
        if (existAdmin.get(0).getAdminPassword().equals(adminPassword)) {
            session.setAttribute("curAdmin", existAdmin.get(0));
            return "登录成功";
        } else {
            return "密码错误";
        }
    }

    @Override
    public String register(String adminName, String adminPassword, HttpSession session) {
        Admin admin = new Admin();
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();

        if (!VerifyMsg.checkPassword(adminPassword)) {
            return "密码首字母为大写，且不可重复";
        }
        if (!VerifyMsg.checkUsername(adminName)) {
            return "用户名以字母开头，由数字和字母组成";
        }
        if (!VerifyMsg.nameIsFormal(adminName)) {
            return "用户名长度不符合规范，长度为3-10";
        }
        if (!VerifyMsg.passwordIsFormal(adminPassword)) {
            return "密码长度不符合规范，长度为8-16";
        }
        if (VerifyMsg.dirtyWords(adminName)) {
            return "含有敏感词汇，请重新输入用户名";
        }

        criteria.andEqualTo("adminName", adminName);
        int count = adminMapper.selectCountByExample(example);
        if (count != 0)
            return "用户名已注册";
        else
            adminMapper.insertSelective(admin);

        List<Admin> existAdmin = adminMapper.selectByExample(example);
        if (existAdmin.get(0) != null) {
            session.setAttribute("curAdmin", existAdmin.get(0));
            return "注册成功";
        }
        return "注册失败";
    }

    @Override
    public int selectAdminCount(Admin admin) {
        return adminMapper.selectCount(admin);
    }

    @Override
    public List<Admin> selectAdminAll() {
        return adminMapper.selectAll();
    }

    @Override
    public List<Admin> selectAdminAllByTypeAndKey(String Type, String key) {
        return adminMapper.selectAdminByTypeAndKey(Type, key);
    }

    @Override
    public void deleteOneAdmin(int id) {
        adminMapper.deleteOneAdmin(id);
    }

    @Override
    public void deleteAllAdmin(int[] id) {
        adminMapper.deleteAllAdmin(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    //分页查询方法
    @Override
    public PageInfo<Admin> findAllAdminByPageS(Admin admin, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> lists = adminMapper.select(admin);
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(lists);
        return pageInfo;
    }
}
