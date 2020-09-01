package com.bcjd.hanxi.controller;

import com.bcjd.hanxi.pojo.Product;
import com.bcjd.hanxi.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product_list")
    @ResponseBody
    public List<Product> product_list(){
        return productService.selectProductAll();
    }

    @RequestMapping("/getProductListByKey")
    @ResponseBody
    public List<Product> getProductListByKey(String type , String key){
        return productService.selectProductAllByKey(type,key);
    }

    @RequestMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        System.out.println(product);
        productService.addProduct(product);
        return "添加成功";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product){
        System.out.println(product);
        productService.updateProduct(product);
        return "修改成功";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteManyProduct",method = RequestMethod.POST)
    public List<Product> deleteManyProduct(int[] delete) {
        productService.deleteManyProduct(delete);
        return productService.selectProductAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOneProduct")
    public List<Product> deleteOneProduct(@RequestBody Product product) {
        productService.deleteOneProduct(product.getId());
        return productService.selectProductAll();
    }

    //分页
    @ResponseBody
    @RequestMapping("/PageHelper")
    public PageInfo<Product> testPageHelper1(Product product, @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "10") int pageSize){
        PageInfo<Product> queryResult = productService.findAllProByPageS(product,pageNum,pageSize);
        System.out.println(queryResult);
        return queryResult;
    }
}
