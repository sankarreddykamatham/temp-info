package com.temp.info.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temp.info.integration.ows.Temparature;
import com.temp.info.integration.ows.TemparatureForecast;
import com.temp.info.integration.ows.TemparatureService;

@RestController
@RequestMapping("/api/weather")
public class TemparatureApiController {

	private final TemparatureService weatherService;

	public TemparatureApiController(TemparatureService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping("/now/{country}/{city}")
	public Temparature getWeather(@PathVariable String country,
			@PathVariable String city) {
		return this.weatherService.getWeather(country, city);
	}

	@RequestMapping("/weekly/{country}/{city}")
	public TemparatureForecast getWeatherForecast(@PathVariable String country,
			@PathVariable String city) {
		return this.weatherService.getWeatherForecast(country, city);
	}

}
