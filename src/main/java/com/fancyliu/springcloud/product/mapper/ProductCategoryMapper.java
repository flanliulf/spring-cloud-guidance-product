package com.fancyliu.springcloud.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fancyliu.springcloud.product.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类描述:
 * 商品分类 dao 接口
 *
 * @author : Liu Fan
 * @date : 2019-06-17 17:32
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    /**
     * 根据给定商品分类,查询该分类下所有商品列表
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryType(@Param("categoryTypeList") List<Integer> categoryTypeList);

}
