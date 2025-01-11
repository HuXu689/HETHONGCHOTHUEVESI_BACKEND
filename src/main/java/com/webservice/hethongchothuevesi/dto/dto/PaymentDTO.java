package com.webservice.hethongchothuevesi.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

public abstract class PaymentDTO {
    @Builder
    @AllArgsConstructor  // Thêm constructor có thể truy cập
    public static class VNPayResponse {
        public String code;
        public String message;
        public String paymentUrl;
    }
}
