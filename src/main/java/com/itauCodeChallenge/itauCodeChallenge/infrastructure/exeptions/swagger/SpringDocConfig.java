package com.itauCodeChallenge.itauCodeChallenge.infrastructure.exeptions.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Challege ITAU")
                        .version("V1")
                        .description("Test Api..."));
    }
}
