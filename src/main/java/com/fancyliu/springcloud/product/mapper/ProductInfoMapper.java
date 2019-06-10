package com.fancyliu.springcloud.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fancyliu.springcloud.product.entity.ProductInfo;

import java.util.List;

public interface ProductInfoMapper extends BaseMapper<ProductInfo> {

    List<ProductInfo> listAll();
}
