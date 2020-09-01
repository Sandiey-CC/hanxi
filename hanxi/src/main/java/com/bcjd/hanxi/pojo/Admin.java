package com.bcjd.hanxi.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`admin`")
public class Admin implements Serializable {
    /**
     * 唯一主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 总部负责人名字
     */
    @Column(name = "`admin_name`")
    private String adminName;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    private static final long serialVersionUID = 1L;

    /**
     * 获取唯一主键
     *
     * @return id - 唯一主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置唯一主键
     *
     * @param id 唯一主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取总部负责人名字
     *
     * @return admin_name - 总部负责人名字
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置总部负责人名字
     *
     * @param adminName 总部负责人名字
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getAdminPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setAdminPassword(String password) {
        this.password = password;
    }
    public Admin() {
    	super();
    }
}