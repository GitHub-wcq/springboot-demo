package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/city")
public class CityController {

	@Resource(name = "cityService")
	private CityService cityService;
	
	@ApiOperation(value="查找城市", notes="查找城市")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true)
	@RequestMapping(value = "/findCityById" ,method=RequestMethod.GET)
	public String findCityById(Integer id) {
		City city = cityService.findCityById(id);
		return city.toString();
	}
	
	@ApiOperation(value="保存城市", notes="保存城市")
    @ApiImplicitParam(name = "city", value = "城市", paramType = "query", required = true)
	@RequestMapping(value = "/saveCity" ,method=RequestMethod.POST)
	public String saveCity(City city) {
		Integer id = cityService.saveCity(city);
		return id.toString();
	}
	
	@ApiOperation(value="更新城市", notes="更新城市")
    @ApiImplicitParam(name = "city", value = "城市", paramType = "query", required = true)
	@RequestMapping(value = "/updateCity" ,method=RequestMethod.POST)
	public String updateCity(City city) {
		Integer id = cityService.updateCity(city);
		return id.toString();
	}
	
	@ApiOperation(value="删除城市", notes="删除城市")
    @ApiImplicitParam(name = "id", value = "id号", paramType = "query", required = true)
	@RequestMapping(value = "/deleteCity" ,method=RequestMethod.POST)
	public String deleteCity(Integer id) {
		Integer res = cityService.deleteCity(id);
		return res.toString();
	}
	
}
