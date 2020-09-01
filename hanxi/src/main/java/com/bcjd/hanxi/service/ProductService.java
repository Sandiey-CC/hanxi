package com.bcjd.hanxi.service;

import com.bcjd.hanxi.pojo.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {

    List<Product> selectProductAll();

    List<Product> selectProductAllByKey(String type , String key);

    void addProduct(Product product);


    void updateProduct(Product product);

    //批量删除商品
    void deleteManyProduct(int[] delete);

    //删除单个商品
    void deleteOneProduct(Integer id);

    //分页
    PageInfo<Product> findAllProByPageS(Product product, int pageNum, int pageSize);
}
