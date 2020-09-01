package com.bcjd.hanxi.service.impl;

import com.bcjd.hanxi.mapper.ProductMapper;
import com.bcjd.hanxi.pojo.Product;
import com.bcjd.hanxi.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectProductAll() {
        return productMapper.selectAll();
    }

    @Override
    public List<Product> selectProductAllByKey(String type, String key) {
        return productMapper.selectProductAllByKey(type,key);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteManyProduct(int[] delete) {
        productMapper.deleteManyProduct(delete);
    }

    @Override
    public void deleteOneProduct(Integer id) {
        productMapper.deleteOneProduct(id);

    }

    @Override
    public PageInfo<Product> findAllProByPageS(Product product, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> lists = productMapper.select(product);
        PageInfo<Product> pageInfo = new PageInfo<Product>(lists);
        return pageInfo;
    }
}
