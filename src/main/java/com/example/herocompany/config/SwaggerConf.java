package com.example.herocompany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//TODO: @Query ve  query içerisinde innerjoin kullanımı
//springin kendi sitesinde jpql sorgusu olarak geçiyor.
@EnableSwagger2
@Configuration
public class SwaggerConf {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.herocompany"))
               // .paths(PathSelectors.regex("/api.*"))
                .build();
    }
}
