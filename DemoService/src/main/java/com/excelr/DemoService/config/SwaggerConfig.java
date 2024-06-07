package com.excelr.DemoService.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

@Bean
public Docket api()
 {
return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage(
				"com.excelr.DemoService.controller"))
		.build();
}

private ApiInfo apiInfo() {
return new ApiInfoBuilder()
.title("Library API")
.description("Library API referance for developers")
.termsOfServiceUrl("http://abc.com")
.license("Library License")
.version("1.0")
.build();
	}

}