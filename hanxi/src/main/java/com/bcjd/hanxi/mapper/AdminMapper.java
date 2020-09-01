package com.bcjd.hanxi.mapper;

import com.bcjd.hanxi.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Repository
public interface AdminMapper extends tk.mybatis.mapper.common.Mapper<Admin> {
    List<Admin> selectAdminByTypeAndKey(String type, String key);

    //删除单个管理员
    void deleteOneAdmin(int id);

    //批量删除管理员
    void deleteAllAdmin(int[] id);

    //更新管理员信息
    public void updateAdmin(@Param("admin") Admin admin);

}




