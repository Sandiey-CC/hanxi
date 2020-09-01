package com.bcjd.hanxi.pojo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
作者： 高登毅
用于接收进货页面dealer_add_product2.html的数据
* */
public class OrdersExt2 implements Serializable {

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
     * 收货经销商地址
     */
    private String address;

    /**
     * 订单中商品数量
     */
    private Integer count;

    /**
     * 订单备注
     */
    private String remarks;

    /**
     * 订单中商品单价
     */
    private BigDecimal price;

    /**
     * 订单状态(未出货/未收货/已确认收货)
     */

    private String state;

    /**
     * 发货经销商ID
     */

    private Integer sendDealerId;

    /**
     * 订单产品表id
     */
    private Integer productId;

    /**
     * 收货经销商Id
     */

    private Integer getDealerId;

/*
发货的仓库id
* */
private Integer dealerStockId;

/*该库存中该商品的新库存数量
* */
private Integer newDealerStockProductCount;

///////////////////////////////////////////////////get and set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getSendDealerId() {
        return sendDealerId;
    }

    public void setSendDealerId(Integer sendDealerId) {
        this.sendDealerId = sendDealerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getGetDealerId() {
        return getDealerId;
    }

    public void setGetDealerId(Integer getDealerId) {
        this.getDealerId = getDealerId;
    }

    public Integer getDealerStockId() {
        return dealerStockId;
    }

    public void setDealerStockId(Integer dealerStockId) {
        this.dealerStockId = dealerStockId;
    }

    public Integer getNewDealerStockProductCount() {
        return newDealerStockProductCount;
    }

    public void setNewDealerStockProductCount(Integer newDealerStockProductCount) {
        this.newDealerStockProductCount = newDealerStockProductCount;
    }

    //////////////////////////////////////////////////////////////////////////    toString

    @Override
    public String toString() {
        return "OrdersExt2{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", completeTime=" + completeTime +
                ", address='" + address + '\'' +
                ", count=" + count +
                ", remarks='" + remarks + '\'' +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", sendDealerId=" + sendDealerId +
                ", productId='" + productId + '\'' +
                ", getDealerId='" + getDealerId + '\'' +
                ", dealerStockId=" + dealerStockId +
                ", newDealerStockProductCount=" + newDealerStockProductCount +
                '}';
    }

////////////////////////////////////////////////////////////////////////////
}
