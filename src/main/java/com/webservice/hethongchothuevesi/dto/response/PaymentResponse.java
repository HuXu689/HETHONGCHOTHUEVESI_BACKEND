package com.webservice.hethongchothuevesi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
    private String url;
    private String message;
}
