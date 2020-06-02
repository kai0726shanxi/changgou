package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/*
 *功能描述
 * @author gao
 * @date 2020-06-01
 * @description 项目入口$
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan({"com.changgou.user.mapper"})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
