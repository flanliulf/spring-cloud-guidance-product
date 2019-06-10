package com.fancyliu.springcloud.product.service;

import com.fancyliu.springcloud.product.ProductApplicationTests;
import com.fancyliu.springcloud.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void listAll() throws Exception {
        List<ProductInfo> list = productService.listUpAll();

        Assert.assertTrue(list.size() > 0);
    }
}