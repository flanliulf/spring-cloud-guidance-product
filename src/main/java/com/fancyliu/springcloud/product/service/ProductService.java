package com.fancyliu.springcloud.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fancyliu.springcloud.product.entity.ProductInfo;
import com.fancyliu.springcloud.product.enums.ProductStatusEnum;
import com.fancyliu.springcloud.product.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceImpl<ProductInfoMapper, ProductInfo> {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 查询所有上架状态商品列表
     */
    public List<ProductInfo> listUpAll() {
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true, "product_status", ProductStatusEnum.UP);
        List<ProductInfo> list = this.list(queryWrapper);
        return list;
    }

    /**
     * 根据给定的商品 ID  list 查询完整的商品信息
     *
     * @param productIdList 商品 id 列表
     * @return
     */
    public List<ProductInfo> findByProductIds(List<String> productIdList) {
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(true, "product_id", productIdList);
        List<ProductInfo> list = this.list(queryWrapper);
        return list;
    }
}
