package com.fancyliu.springcloud.product.service;

import com.fancyliu.springcloud.product.ProductApplicationTests;
import com.fancyliu.springcloud.product.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryType() {
        List<ProductCategory> categories = this.categoryService.findByCategoryType(Arrays.asList(11, 22));

        Assert.assertTrue(categories.size() > 0);
    }
}