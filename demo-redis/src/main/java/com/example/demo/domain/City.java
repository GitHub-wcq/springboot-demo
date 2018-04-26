package com.example.demo.domain;

public class City implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "City";
	public static final String ALIAS_ID = "城市编号";
	public static final String ALIAS_PROVINCE_ID = "省份编号";
	public static final String ALIAS_CITY_NAME = "城市名称";
	public static final String ALIAS_DESCRIPTION = "描述";
		
	//columns START
	private java.lang.Integer id;
	private java.lang.Integer provinceId;
	private java.lang.String cityName;
	private java.lang.String description;
	//columns END

	public City(){
	}

	public City(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setProvinceId(java.lang.Integer value) {
		this.provinceId = value;
	}
	
	public java.lang.Integer getProvinceId() {
		return this.provinceId;
	}
	public void setCityName(java.lang.String value) {
		this.cityName = value;
	}
	
	public java.lang.String getCityName() {
		return this.cityName;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", provinceId=" + provinceId + ", cityName=" + cityName + ", description="
				+ description + "]";
	}

}

