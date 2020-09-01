package com.bcjd.hanxi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`dealer_stock`")
public class DealerStock implements Serializable {
    /**
     * 唯一主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 该经销商的定价
     */
    @Column(name = "`price`")
    private BigDecimal price;

    /**
     * 库存量
     */
    @Column(name = "`count`")
    private Integer count;

    /**
     * 该库存创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 经销商信息
     */
    @Column(name = "`dealer_id`")
    private Integer dealerId;

    /**
     * 产品表信息
     */
    @Column(name = "`product_id`")
    private Integer productId;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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
     * 获取该经销商的定价
     *
     * @return price - 该经销商的定价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置该经销商的定价
     *
     * @param price 该经销商的定价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取库存量
     *
     * @return count - 库存量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置库存量
     *
     * @param count 库存量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取该库存创建时间
     *
     * @return create_time - 该库存创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置该库存创建时间
     *
     * @param createTime 该库存创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取经销商信息
     *
     * @return dealer_id - 经销商信息
     */
    public Integer getDealerId() {
        return dealerId;
    }

    /**
     * 设置经销商信息
     *
     * @param dealerId 经销商信息
     */
    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    /**
     * 获取产品表信息
     *
     * @return product_id - 产品表信息
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品表信息
     *
     * @param productId 产品表信息
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public DealerStock() {
    	super();
    }
}