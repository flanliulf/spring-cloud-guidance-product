package com.fancyliu.springcloud.product.controller;

import com.fancyliu.springcloud.product.entity.ProductCategory;
import com.fancyliu.springcloud.product.entity.ProductInfo;
import com.fancyliu.springcloud.product.service.CategoryService;
import com.fancyliu.springcloud.product.service.ProductService;
import com.fancyliu.springcloud.product.vo.ProductInfoVO;
import com.fancyliu.springcloud.product.vo.ProductVO;
import com.fancyliu.springcloud.product.vo.ResponseData;
import com.fancyliu.springcloud.product.vo.ResponseDataUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类描述: 
 *
 * 
 * @author : Liu Fan
 * @date : 2019-06-17 17:27
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有上架状态的商品
     * 2. 遍历商品获取分类列表
     * 3. 查询分类
     * 4. 构造数据
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseData list() {

        List<ProductInfo> productInfoList = productService.listUpAll();

        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        List<ProductCategory> categoryList = categoryService.findByCategoryType(categoryTypeList);

        List<ProductVO> productVoList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVoList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVO);
        }


        return ResponseDataUtils.success(200, "查询成功", productVoList);
    }

    /**
     * 获取商品列表(供订单服务调用)
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/list4Order")
    public List<ProductInfo> list4Order(@RequestBody List<String> productIdList) {
        List<ProductInfo> productInfoList = this.productService.findByProductIds(productIdList);
        return productInfoList;
    }
}
