package com.bcjd.hanxi.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "`orders_detail`")
public class OrdersDetail implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`product_id`")
    private Integer productId;

    @Column(name = "`orders_id`")
    private Integer ordersId;

    @Column(name = "`number`")
    private Integer number;

    private Product product;

    private DealerStock dealerStock;

    public DealerStock getDealerStock() {
        return dealerStock;
    }

    public void setDealerStock(DealerStock dealerStock) {
        this.dealerStock = dealerStock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return orders_id
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * @param ordersId
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}