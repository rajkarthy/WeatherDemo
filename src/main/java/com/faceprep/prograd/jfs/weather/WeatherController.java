package com.faceprep.prograd.jfs.weather;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
//    private static final Logger log = LoggerFactory.getLogger(WeatherDemoApplication.class);

	@Autowired
    JdbcTemplate jdbcTemplate;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/weather/get")
	public Weather getWeather(@RequestParam("cityName") String cityName)
	{
		Weather emptyCityWeather = new Weather(cityName, "" , "");		
		
		List<Object> cityWeathers = jdbcTemplate.query("SELECT * FROM weather_table WHERE cityName = ?", new Object[] {cityName} , 
				(rs, rowNum) -> new Weather(rs.getString("cityName") 
						,rs.getString("weatherValues")
						,rs.getString("searchTime"))
		        );
//		jdbcTemplate.update("INSERT INTO weather_table(cityName, weatherValues, searchTime)VALUES(?,?,?)", new Object[] {"KOL","1,2,3,4",""});
		

		
		return cityWeathers.size()>0?(Weather)cityWeathers.get(0):emptyCityWeather;
		
	}

}
