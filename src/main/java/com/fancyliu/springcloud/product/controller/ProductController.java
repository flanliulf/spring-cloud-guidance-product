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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有商品
     * 查询所有商品分类
     * 构造数据
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

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }


        return ResponseDataUtils.success(200, "查询成功", productVOList);
    }
}
