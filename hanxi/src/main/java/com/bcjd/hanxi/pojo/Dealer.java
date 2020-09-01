package com.bcjd.hanxi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`dealer`")
public class Dealer implements Serializable {
    /**
     * 唯一主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 经销商名字
     */
    @Column(name = "`dealer_name`")
    private String dealerName;

    /**
     * 密码
     */
    @Column(name = "`dealer_password`")
    private String dealerPassword;

    /**
     * 经销商身份
     */
    @Column(name = "`level_name`")
    private String levelName;

    /**
     * 代理级别
     */
    @Column(name = "`level`")
    private Integer level;

    /**
     * 手机号
     */
    @Column(name = "`phone`")
    private String phone;

    /**
     * 上级经销商id(若level为1则不填写)
     */
    @Column(name = "`father_id`")
    private String fatherId;

    /**
     * 授权时间
     */
    @Column(name = "`regist_time`")
    private Date registTime;

    /**
     * 授权码(若level为3则没有授权码)
     */
    @Column(name = "`grant_code`")
    private String grantCode;

    /**
     * 收货地址
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 男或者女
     */
    @Column(name = "`sex`")
    private String sex;

    /**
     * 所获得的钱(给下级发货的钱-拿货的钱)
     */
    @Column(name = "`money`")
    private BigDecimal money;

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
     * 获取经销商名字
     *
     * @return dealer_name - 经销商名字
     */
    public String getDealerName() {
        return dealerName;
    }

    /**
     * 设置经销商名字
     *
     * @param dealerName 经销商名字
     */
    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    /**
     * 获取密码
     *
     * @return dealer_password - 密码
     */
    public String getDealerPassword() {
        return dealerPassword;
    }

    /**
     * 设置密码
     *
     * @param dealerPassword 密码
     */
    public void setDealerPassword(String dealerPassword) {
        this.dealerPassword = dealerPassword;
    }

    /**
     * 获取经销商身份
     *
     * @return level_name - 经销商身份
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置经销商身份
     *
     * @param levelName 经销商身份
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 获取代理级别
     *
     * @return level - 代理级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置代理级别
     *
     * @param level 代理级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取上级经销商id(若level为1则不填写)
     *
     * @return father_id - 上级经销商id(若level为1则不填写)
     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     * 设置上级经销商id(若level为1则不填写)
     *
     * @param fatherId 上级经销商id(若level为1则不填写)
     */
    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * 获取授权时间
     *
     * @return regist_time - 授权时间
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * 设置授权时间
     *
     * @param registTime 授权时间
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    /**
     * 获取授权码(若level为3则没有授权码)
     *
     * @return grant_code - 授权码(若level为3则没有授权码)
     */
    public String getGrantCode() {
        return grantCode;
    }

    /**
     * 设置授权码(若level为3则没有授权码)
     *
     * @param grantCode 授权码(若level为3则没有授权码)
     */
    public void setGrantCode(String grantCode) {
        this.grantCode = grantCode;
    }

    /**
     * 获取收货地址
     *
     * @return address - 收货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置收货地址
     *
     * @param address 收货地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取男或者女
     *
     * @return sex - 男或者女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置男或者女
     *
     * @param sex 男或者女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取所获得的钱(给下级发货的钱-拿货的钱)
     *
     * @return money - 所获得的钱(给下级发货的钱-拿货的钱)
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置所获得的钱(给下级发货的钱-拿货的钱)
     *
     * @param money 所获得的钱(给下级发货的钱-拿货的钱)
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

	public Dealer() {
		super();
	}

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", dealerName='" + dealerName + '\'' +
                ", dealerPassword='" + dealerPassword + '\'' +
                ", levelName='" + levelName + '\'' +
                ", level=" + level +
                ", phone='" + phone + '\'' +
                ", fatherId='" + fatherId + '\'' +
                ", registTime=" + registTime +
                ", grantCode='" + grantCode + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", money=" + money +
                '}';
    }
}