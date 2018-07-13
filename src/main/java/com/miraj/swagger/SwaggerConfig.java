package com.miraj.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {  
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.miraj.service"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metaInfo());
    }

	private ApiInfo metaInfo() {
		ApiInfo apiInfo=new ApiInfo("Blood Donation Application", "This application is developed in Spring Boot framework", "1.0",
				null, "Shahriar Miraj, email: smiraj2507@gmail.com", null, null);
		return apiInfo;
	}
    
}
