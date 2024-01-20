package com.example.payment.config;

import com.siot.IamportRestClient.IamportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IamportConfig {

    @Value("${imp.api.key}")
    private String key;
    @Value("${imp.api.secretkey}")
    private String secretkey;

    @Bean
    public IamportClient initIamport() {
        return new IamportClient(key, secretkey);
    }
}
