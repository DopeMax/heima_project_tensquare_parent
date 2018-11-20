package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import utils.IdWorker;

/**
 * 基础微服务的启动类
 */
@SpringBootApplication
public class BaseApplication {

    /**
     * 启动方法
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }

    /**
     * 准备一个id生成器并且存入spring的容器中
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }
}
