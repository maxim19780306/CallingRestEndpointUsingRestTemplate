package com.example.CallingRestEndpointUsingRestTemplate.controller;

import com.example.CallingRestEndpointUsingRestTemplate.model.Payment;
import com.example.CallingRestEndpointUsingRestTemplate.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}
