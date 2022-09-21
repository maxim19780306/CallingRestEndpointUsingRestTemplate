package com.example.CallingRestEndpointUsingRestTemplate.proxy;

import com.example.CallingRestEndpointUsingRestTemplate.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@Component
public class PaymentsProxy {

    private RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentsProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        String uri = paymentServiceUrl + "/payment";

        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);

        ResponseEntity<Payment> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);

        return responseEntity.getBody();
    }
}
