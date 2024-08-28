package com.project.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.project.constants.ResourcePathAndActionsConstants;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(ResourcePathAndActionsConstants.ORIGIN)
			.allowedMethods(ResourcePathAndActionsConstants.GET, ResourcePathAndActionsConstants.POST,
				ResourcePathAndActionsConstants.PUT, ResourcePathAndActionsConstants.DELETE,
				ResourcePathAndActionsConstants.OPTIONS)
			.allowedHeaders("*").allowCredentials(true);
	    }
	};
    }
}
