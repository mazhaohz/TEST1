package com.sunyard.apigetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringCloudApplication
public class ApiGetwayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiGetwayApplication.class, args) ;
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}

	@Bean
	public PatternServiceRouteMapper serviceRouteMapper(){
		return new PatternServiceRouteMapper
				("(?<name>^.+)-(?<version>v.+$)",
						"${version}/${name}");
	}
}
