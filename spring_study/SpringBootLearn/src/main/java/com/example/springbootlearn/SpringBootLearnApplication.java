package com.example.springbootlearn;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootLearnApplication {
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootLearnApplication.class);
		//修改Banner的模式为OFF
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}
}
