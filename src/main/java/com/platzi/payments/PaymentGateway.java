package com.platzi.payments;

import com.platzi.payments.library_mock.PaymentRequest;
import com.platzi.payments.library_mock.PaymentResponse;

// pasarela de pagos que utilizamos a traves de una interface que interactura con una librería
public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
