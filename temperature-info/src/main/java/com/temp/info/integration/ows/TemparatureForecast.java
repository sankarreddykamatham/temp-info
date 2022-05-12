package com.temp.info.integration.ows;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TemparatureForecast implements Serializable {

	private String name;

	private List<TemparatureEntry> entries = new ArrayList<>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("entries")
	public List<TemparatureEntry> getEntries() {
		return this.entries;
	}

	@JsonSetter("list")
	public void setEntries(List<TemparatureEntry> entries) {
		this.entries = entries;
	}

	@JsonProperty("city")
	public void setCity(Map<String, Object> city) {
		setName(city.get("name").toString());
	}

}
