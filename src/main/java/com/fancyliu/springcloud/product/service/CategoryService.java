package com.fancyliu.springcloud.product.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fancyliu.springcloud.product.entity.ProductCategory;
import com.fancyliu.springcloud.product.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述: 
 * 
 * 
 * @author : Liu Fan
 * @date : 2019-06-17 17:32
 */
@Service
public class CategoryService extends ServiceImpl<ProductCategoryMapper, ProductCategory> {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList) {
        return this.productCategoryMapper.findByCategoryType(categoryTypeList);
    }

}
