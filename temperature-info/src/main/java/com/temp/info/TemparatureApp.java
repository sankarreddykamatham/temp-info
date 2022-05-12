package com.temp.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties(TemparatureAppProperties.class)
@EnableCaching(proxyTargetClass = true)
public class TemparatureApp {

	public static void main(String[] args) {
		SpringApplication.run(TemparatureApp.class, args);
	}

}
