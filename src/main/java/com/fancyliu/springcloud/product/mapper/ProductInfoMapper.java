package com.fancyliu.springcloud.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fancyliu.springcloud.product.entity.ProductInfo;

import java.util.List;

/**
 * 类描述:
 * 商品 dao 接口
 *
 * @author : Liu Fan
 * @date : 2019-06-17 17:32
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {

    /**
     * 查询所有商品列表
     *
     * @return
     */
    List<ProductInfo> listAll();
}
