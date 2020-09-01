package com.bcjd.hanxi.mapper;

import com.bcjd.hanxi.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Repository
public interface ProductMapper extends tk.mybatis.mapper.common.Mapper<Product> {
    List<Product> selectProductAllByKey(String type,String key);

    void addProduct(@Param("product") Product product);

    void updateProduct(@Param("product") Product product);

    //批量删除商品
    void deleteManyProduct(int[] delete);

    //删除单个商品
    void deleteOneProduct(Integer id);
}




