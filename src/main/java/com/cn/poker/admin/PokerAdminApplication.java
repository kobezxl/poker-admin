package com.cn.poker.admin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PokerAdminApplication extends SpringBootServletInitializer {

	public static ConfigurableApplicationContext ac;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PokerAdminApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		PokerAdminApplication.ac = application.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.bannerMode(Banner.Mode.OFF);
		return application.sources(PokerAdminApplication.class);
	}
}
