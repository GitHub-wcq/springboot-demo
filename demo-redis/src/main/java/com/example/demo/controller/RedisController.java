package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.redis.RedisUtil;

@RestController
@RequestMapping("redis")
public class RedisController {
	@Autowired
	private RedisUtil redisUtil;
	
	
	
	@RequestMapping(value = "/test",method = RequestMethod.POST)
    public String demoTest(){
		redisUtil.set("1","value22222");
		return "success";
    }
	
	@RequestMapping(value = "/getTest",method = RequestMethod.GET)
	public String getTest(String key) {
		return (String) redisUtil.get(key);
	}
	
	

}
