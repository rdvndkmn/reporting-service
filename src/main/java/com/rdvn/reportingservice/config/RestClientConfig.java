package com.rdvn.reportingservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Configuration
public class RestClientConfig {


    @Bean
    public RestClient adServiceRestClient(
            @Value("${ad.service.username}") String username,
            @Value("${ad.service.password}") String password) {

        return RestClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeaders(headers -> headers.setBasicAuth(username, password))
                .build();
    }

}

