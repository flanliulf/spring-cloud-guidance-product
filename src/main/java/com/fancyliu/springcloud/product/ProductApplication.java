package com.fancyliu.springcloud.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类描述: 
 * 启动类
 * 
 * @author : Liu Fan
 * @date : 2019-06-17 17:31
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.fancyliu.springcloud.product.mapper")
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
