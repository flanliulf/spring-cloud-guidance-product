package com.fancyliu.springcloud.product.mapper;

import com.fancyliu.springcloud.product.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void findByCategoryType() throws Exception {
        List<ProductCategory> list = productCategoryMapper.findByCategoryType(Arrays.asList(11, 12));
        Assert.assertTrue(list.size() > 0);
    }

}