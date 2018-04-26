package com.example.demo.dao;

import java.util.List;
import java.util.Map;
import com.example.annotation.MyBatisRepository;
import com.example.demo.domain.City;

@MyBatisRepository
public interface CityDao{

	Integer insert(City entity);
	
	Integer update(City entity);
	
	Integer delete(java.lang.Integer id);
	
	City getById(java.lang.Integer id);

	int count();
	
	List<City> findPage(Map<String, Object> param);

}
