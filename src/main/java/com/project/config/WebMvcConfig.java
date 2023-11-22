package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.common.FileManagerService;
import com.project.interceptor.PermissionInterceptor;

@Configuration 
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private PermissionInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
		.addInterceptor(interceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/error", "/static/**", "/user/sign-out")
		;
	}
	
	
	//웹 이미지 path와 서버에 업로드 된 이미지를 mapping설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/images/**") //images로 시작하고 그 뒤에 뭐가 있던간에 
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH); // 실제 파일 위치
	}
	
}
