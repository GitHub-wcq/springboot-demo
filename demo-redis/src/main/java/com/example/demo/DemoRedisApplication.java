package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching//缓存
@SpringBootApplication
@ServletComponentScan  //设置启动时spring能够扫描到我们自己编写的servlet和filter, 用于Druid监控
@MapperScan("com.example.**.dao") //配置扫描mapper接口的地址 
public class DemoRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRedisApplication.class, args);
	}
}
