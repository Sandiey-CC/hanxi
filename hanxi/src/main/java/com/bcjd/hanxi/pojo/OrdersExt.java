package com.bcjd.hanxi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrdersExt implements Serializable {
    /**
     * 唯一主键
     */

    private Integer id;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单完成时间
     */
    private Date completeTime;

    /**
     * 经销商地址
     */
    private String address;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 发货的价格
     */
    private BigDecimal price;

    /**
     * 订单状态(未扫码出货/未收货/已确认收货)
     */
    private String state;

    /**
     * 上级经销商发货
     */
//    private String sendDealerName;

    /**
     * 对应产品表id
     */
    private Product product;

    /**
     * 下级经销商拿货
     */
    private Dealer dealer;
//    private String getDealerName;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }


    //    /**
//     * 获取上级经销商发货
//     *
//     * @return send_dealer_id - 上级经销商发货
//     */
//    public String getSendDealerName() {
//        return sendDealerName;
//    }
//
//    /**
//     * 设置上级经销商发货
//     *
//     * @param sendDealerName 上级经销商发货
//     */
//    public void setSendDealerName(String sendDealerName) {
//        this.sendDealerName = sendDealerName;
//    }
//
//    /**
//     * 获取对应产品表id
//     *
//     * @return product_id - 对应产品表id
//     */
//    public String getProductName() {
//        return productName;
//    }
//
//    /**
//     * 设置对应产品表id
//     *
//     * @param productName 对应产品表id
//     */
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    /**
//     * 获取下级经销商拿货
//     *
//     * @return get_dealer_id - 下级经销商拿货
//     */
//    public String getGetDealerName() {
//        return getDealerName;
//    }
//
//    /**
//     * 设置下级经销商拿货
//     *
//     * @param getDealerName 下级经销商拿货
//     */
//    public void setGetDealerName(String getDealerName) {
//        this.getDealerName = getDealerName;
//    }
    List<OrdersDetail> ordersDetail;

    public List<OrdersDetail> getOrdersDetail() {
        return ordersDetail;
    }

    public void setOrdersDetail(List<OrdersDetail> ordersDetail) {
        this.ordersDetail = ordersDetail;
    }
}