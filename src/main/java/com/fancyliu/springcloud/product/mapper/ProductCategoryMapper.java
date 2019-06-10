package com.fancyliu.springcloud.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fancyliu.springcloud.product.entity.ProductCategory;import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    List<ProductCategory> findByCategoryType(@Param("categoryTypeList") List<Integer> categoryTypeList);

}
