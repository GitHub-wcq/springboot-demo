package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CityDao;
import com.example.demo.domain.City;
@SuppressWarnings({"rawtypes","unchecked"})
@Service("cityService")
public class CityServiceImpl implements CityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
	@Autowired
	private CityDao cityDao;
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
	@Override
	public City findCityById(Integer id) {
		// 从缓存中获取城市信息
		String key = "city_" + id;
		ValueOperations<String, City> operations = redisTemplate.opsForValue();
		// 缓存存在
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
            City city = operations.get(key);
            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }
		// 从 DB 中获取城市信息
		City city = cityDao.getById(id);
		// 插入缓存
		operations.set(key, city, 10, TimeUnit.MINUTES);
		LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
		return city;
	}

	@Override
	public Integer saveCity(City city) {
		return cityDao.insert(city);
	}

	/**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
	@Override
	public Integer updateCity(City city) {
		Integer ret = cityDao.update(city);
		// 缓存存在，删除缓存
		String key = "city_" + city.getId();
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }
        return ret;
	}

	@Override
	public Integer deleteCity(Integer id) {
		Integer ret = cityDao.delete(id);
		// 缓存存在，删除缓存
		String key = "city_" + id;
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }
		return ret;
	}

}
