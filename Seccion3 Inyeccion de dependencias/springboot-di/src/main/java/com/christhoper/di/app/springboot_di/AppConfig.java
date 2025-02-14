package com.christhoper.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.christhoper.di.app.springboot_di.repositories.ProductRepository;
import com.christhoper.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductRepository ProductRepositoryJson(){
        return new ProductRepositoryJson();
    }

}
