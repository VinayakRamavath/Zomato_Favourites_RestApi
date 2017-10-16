package com.stackroute.foodapp.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//you can access your rest api documentation by going to the below link
//http://localhost:8080/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.foodapp"))
                .paths(PathSelectors.regex("/v1.0/FavouriteService/Favourites.*"))
                .build()
                .apiInfo(metaData());
             
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "FoodApp Favourites REST API",
                "FoodApp Favourites REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("Vinayak Ramavath", "https://springframework.vinayak/about/", "vinayak@cgi.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}