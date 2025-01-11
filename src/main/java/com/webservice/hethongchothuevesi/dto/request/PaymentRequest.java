package com.webservice.hethongchothuevesi.dto.request;

import lombok.Data;

@Data
public class PaymentRequest {
    private Integer idHoaDon;
    private Long amount; // Số tiền thanh toán
    private String description;
}
