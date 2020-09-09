package com.example.consumer.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Swagger2Config
 * @User zhang
 * @Description
 * @Author Lucien
 * @Date 2020/8/27 23:16
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.consumer.feign.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Lucien Service")
                .description("This is my SpringCloud Alibaba MicroService")
                .termsOfServiceUrl("https://github.com/zhanghexi")
                .contact(new Contact("Lucien", "", "zhanghexi891121@163.com"))
                .version("1.0")
                .build();
    }
}
