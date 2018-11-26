package com.bookapp.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bookapp.zuulgateway.filters.ErrorFilter;
import com.bookapp.zuulgateway.filters.PostFilter;
import com.bookapp.zuulgateway.filters.PreFilter;
import com.bookapp.zuulgateway.filters.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class BookappZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookappZuulGatewayApplication.class, args);
	}
	//@Bean
	public PreFilter preFilter(){
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter(){
		return new PostFilter();
	}
	@Bean
	public RouteFilter routeFilter(){
		return new RouteFilter();
	}
	@Bean
	public ErrorFilter errorFilter(){
		return new ErrorFilter();
	}

}
