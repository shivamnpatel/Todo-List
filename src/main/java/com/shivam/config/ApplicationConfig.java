package com.shivam.config;
// Alternate file for frontController-servlet.xml

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.shivam.interceptor.AuthenticationInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.shivam.controllers,com.shivam.dao" })
public class ApplicationConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/js/**").addResourceLocations("/js/");

		registry.addResourceHandler("/css/**").addResourceLocations("/css/");

		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new AuthenticationInterceptor());
	}

}
