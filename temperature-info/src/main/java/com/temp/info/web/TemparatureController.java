package com.temp.info.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.temp.info.TemparatureAppProperties;
import com.temp.info.integration.ows.Temparature;
import com.temp.info.integration.ows.TemparatureService;

@Controller
@RequestMapping("/")
public class TemparatureController {

	private final TemparatureService weatherService;

	private final TemparatureAppProperties properties;

	public TemparatureController(TemparatureService weatherService, TemparatureAppProperties properties) {
		this.weatherService = weatherService;
		this.properties = properties;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView conferenceWeather() {
		Map<String, Object> model = new LinkedHashMap<>();
		model.put("summary", getSummary());
		return new ModelAndView("summary", model);
	}

	private Object getSummary() {
		List<TemparatureSummary> summary = new ArrayList<>();
		for (String location : this.properties.getLocations()) {
			String country = location.split("/")[0];
			String city = location.split("/")[1];
			Temparature weather = this.weatherService.getWeather(country, city);
			summary.add(createWeatherSummary(country, city, weather));
		}
		return summary;
	}



	private TemparatureSummary createWeatherSummary(String country, String city,
			Temparature weather) {
		// cough cough
		if ("Las Vegas".equals(city)) {
			weather.setWeatherId(666);
		}
		return new TemparatureSummary(country, city, weather);
	}

}
