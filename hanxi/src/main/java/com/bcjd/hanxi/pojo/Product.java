package com.bcjd.hanxi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "`product`")
public class Product implements Serializable {
    /**
     * 唯一主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 商品名字
     */
    @Column(name = "`product_name`")
    private String productName;

    /**
     * 原始价格
     */
    @Column(name = "`price`")
    private BigDecimal price;

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
     * 获取商品名字
     *
     * @return product_name - 商品名字
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名字
     *
     * @param productName 商品名字
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取原始价格
     *
     * @return price - 原始价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置原始价格
     *
     * @param price 原始价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Product() {
    	super();
    }
}