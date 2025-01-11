// src/main/java/com/webservice/hethongchothuevesi/controller/PaymentController.java

package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.dto.dto.PaymentDTO;
import com.webservice.hethongchothuevesi.dto.response.ResponseObject;
import com.webservice.hethongchothuevesi.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/vnpay")
    public ResponseObject<PaymentDTO.VNPayResponse> pay(HttpServletRequest request,
                                                        @RequestParam Integer idHoaDon) {
        return new ResponseObject<>(HttpStatus.OK, "Success",
                paymentService.createVnPayPayment(request, idHoaDon));
    }


    @GetMapping("/vnpay/callback")
    public ResponseObject<PaymentDTO.VNPayResponse> payCallbackHandler(HttpServletRequest request) {
        String status = request.getParameter("vnp_ResponseCode");
        if (status.equals("00")) {
            return new ResponseObject<>(HttpStatus.OK, "Success", new PaymentDTO.VNPayResponse("00", "Success", ""));
        } else {
            return new ResponseObject<>(HttpStatus.BAD_REQUEST, "Failed", null);
        }
    }

}