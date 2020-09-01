package com.bcjd.hanxi.service;

import com.bcjd.hanxi.pojo.Admin;
import com.bcjd.hanxi.pojo.Dealer;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminService {
	String login(String adminName, String adminPassword,HttpSession session);
	String register(String adminName, String adminPassword,HttpSession session);
	int selectAdminCount(Admin admin);
	List<Admin> selectAdminAll();
	List<Admin> selectAdminAllByTypeAndKey(String Type ,String key);

	//删除单个管理员
	void deleteOneAdmin(int id);

	//批量删除管理员
	void deleteAllAdmin(int[] id);

	//更新管理员信息
	void updateAdmin(Admin admin);

	//分页
	PageInfo<Admin> findAllAdminByPageS(Admin admin, int pageNum, int pageSize);
}
