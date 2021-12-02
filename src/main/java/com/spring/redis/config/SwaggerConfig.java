package com.spring.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket SwaggerApi() {
    String apiName = "SwaggerApi";
    String apiVersion = "v1";
    String apiDescription = String.format("Documentation %s %s", apiName, apiVersion);

    return new Docket(DocumentationType.SWAGGER_2)
        .groupName(apiName)
        // Swagger API Docs Description
        .apiInfo(
            new ApiInfoBuilder()
                .version(apiVersion)
                .title(apiName)
                .description(apiDescription)
                .build()
        )
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.spring.redis.controller"))

        .paths(PathSelectors.regex(".*?"))
        .build();
  }
}