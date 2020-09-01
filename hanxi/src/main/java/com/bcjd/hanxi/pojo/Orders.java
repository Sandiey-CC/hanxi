package com.bcjd.hanxi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Table(name = "`orders`")
public class Orders implements Serializable {
    /**
     * 唯一主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 订单创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 订单完成时间
     */
    @Column(name = "`complete_time`")
    private Date completeTime;

    /**
     * 经销商地址
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 商品数量
     */
    @Column(name = "`count`")
    private Integer count;

    /**
     * 备注
     */
    @Column(name = "`remarks`")
    private String remarks;

    /**
     * 发货的价格
     */
    @Column(name = "`price`")
    private BigDecimal price;

    /**
     * 订单状态(未扫码出货/未收货/已确认收货)
     */
    @Column(name = "`state`")
    private String state;

    /**
     * 上级经销商发货
     */
    @Column(name = "`send_dealer_id`")
    private Integer sendDealerId;

    /**
     * 对应产品表id
     */
    @Column(name = "`product_id`")
    private Integer productId;

    /**
     * 下级经销商拿货
     */
    @Column(name = "`get_dealer_id`")
    private Integer getDealerId;

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
     * 获取订单创建时间
     *
     * @return create_time - 订单创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取订单完成时间
     *
     * @return complete_time - 订单完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置订单完成时间
     *
     * @param completeTime 订单完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 获取经销商地址
     *
     * @return address - 经销商地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置经销商地址
     *
     * @param address 经销商地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取商品数量
     *
     * @return count - 商品数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置商品数量
     *
     * @param count 商品数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取发货的价格
     *
     * @return price - 发货的价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置发货的价格
     *
     * @param price 发货的价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取订单状态(未扫码出货/未收货/已确认收货)
     *
     * @return state - 订单状态(未扫码出货/未收货/已确认收货)
     */
    public String getState() {
        return state;
    }

    /**
     * 设置订单状态(未扫码出货/未收货/已确认收货)
     *
     * @param state 订单状态(未扫码出货/未收货/已确认收货)
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取上级经销商发货
     *
     * @return send_dealer_id - 上级经销商发货
     */
    public Integer getSendDealerId() {
        return sendDealerId;
    }

    /**
     * 设置上级经销商发货
     *
     * @param sendDealerId 上级经销商发货
     */
    public void setSendDealerId(Integer sendDealerId) {
        this.sendDealerId = sendDealerId;
    }

    /**
     * 获取对应产品表id
     *
     * @return product_id - 对应产品表id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置对应产品表id
     *
     * @param productId 对应产品表id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取下级经销商拿货
     *
     * @return get_dealer_id - 下级经销商拿货
     */
    public Integer getGetDealerId() {
        return getDealerId;
    }

    /**
     * 设置下级经销商拿货
     *
     * @param getDealerId 下级经销商拿货
     */
    public void setGetDealerId(Integer getDealerId) {
        this.getDealerId = getDealerId;
    }

    /**
     * dealer对象
     */
    @Column(name = "`dealer`")
    private Dealer dealer;

    public Dealer getDealer() {
        return dealer;
    }


    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}