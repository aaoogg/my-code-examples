package com.project.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.project.config.security.TokenInterceptor;
import com.project.project.constants.ResourcePathAndActionsConstants;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;

    @Autowired
    public WebConfig(TokenInterceptor tokenInterceptor) {
	this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping(ResourcePathAndActionsConstants.API_ALL)
		.allowedOrigins(ResourcePathAndActionsConstants.ORIGIN)
		.allowedMethods(ResourcePathAndActionsConstants.GET, ResourcePathAndActionsConstants.POST,
			ResourcePathAndActionsConstants.PUT, ResourcePathAndActionsConstants.DELETE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(tokenInterceptor).addPathPatterns(ResourcePathAndActionsConstants.API_ALL)
		.excludePathPatterns(ResourcePathAndActionsConstants.AUTH_ALL);
    }
}
