package com.github.jbrasileiro.primso.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.classmate.TypeResolver;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    
    @Bean
    public Docket api(final TypeResolver resolver,
                        @Value("${spring.application.name}") 
    					final String applicationName,
                        @Value("${version:latest}")
    					final String version) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(version)
                .apiInfo(getApiInfo(version, applicationName))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                ;
    }

    private ApiInfo getApiInfo(final String version
    		, final String aplicationName) {
        return new ApiInfoBuilder()
                .title(aplicationName)
                .description("Swagger for application")
                .contact(new Contact("jbrasileiro", "https://github.com/jbrasileiro", "no-reply@jbrasileiro.com"))
                .version(version)
                .build();
    }
    
}
