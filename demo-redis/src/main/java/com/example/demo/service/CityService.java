package com.example.demo.service;

import com.example.demo.domain.City;

public interface CityService {
	
	City findCityById(Integer id);
	
	Integer saveCity(City city);
	
	Integer updateCity(City city);
	
	Integer deleteCity(Integer id);

}
