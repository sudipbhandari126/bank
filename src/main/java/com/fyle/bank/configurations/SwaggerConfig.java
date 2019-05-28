package com.fyle.bank.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Autowired
    Environment environment;

    private ApiInfo metaData() {
        String serviceName="Bank Service running at profile:: "+ Arrays.toString(environment.getActiveProfiles());
        return new ApiInfo(
                serviceName,
                "This is a demo of bank and branch services",
                "1.0.0",
                "Feel free to play around",
                 new Contact("Sudip Bhandari","https://sudipbhandari126.github.io","sudip.post@gmail.com"),
                null,
                null,
                new ArrayList<>());
    }


    @Bean
    public Docket api() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }
}
