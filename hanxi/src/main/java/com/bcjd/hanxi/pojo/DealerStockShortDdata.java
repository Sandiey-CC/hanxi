package com.bcjd.hanxi.pojo;


import java.io.Serializable;
import java.math.BigDecimal;

/*
作者：高登毅
用于接收 DealerStock表与product表做连结查询后的数据。
* */
public class DealerStockShortDdata implements Serializable {

    /*
    仓库id
    * */
    private Integer dealerStorkId;
    /*
仓库中的商品名
* */
    String productName;
    /*
    仓库中的商品数量
    * */
    Long count;
    /*
仓库中商品该经销商的定价
* */
    private BigDecimal price;
    /*
    拥有该仓库的进销商id
    * */
    private Integer dealerId;

    /*
    仓库中的商品的id
    * */
    private Integer productId;
    //////////////////////////////get and  set

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDealerStorkId() {
        return dealerStorkId;
    }

    public void setDealerStorkId(Integer dealerStorkId) {
        this.dealerStorkId = dealerStorkId;
    }
    //////////////////////////////////////toString

    @Override
    public String toString() {
        return "DealerStockShortDdata{" +
                "dealerStorkId=" + dealerStorkId +
                ", productName='" + productName + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", dealerId=" + dealerId +
                ", productId=" + productId +
                '}';
    }


    /////////////////////////////////////////////////
}
