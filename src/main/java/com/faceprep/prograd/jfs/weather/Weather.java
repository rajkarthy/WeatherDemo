package com.faceprep.prograd.jfs.weather;


public class Weather {
	private String cityName;
	private String weatherValues;
	private String searchTime;

	public Weather(String cityName, String weatherValues, String searchTime) {
		super();
		this.cityName = cityName;
		this.weatherValues = weatherValues;
		this.searchTime = searchTime;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getWeatherValues() {
		return weatherValues;
	}

	public void setWeatherValues(String weatherValues) {
		this.weatherValues = weatherValues;
	}

	public String getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}

	

}
