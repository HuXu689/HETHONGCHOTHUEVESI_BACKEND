package com.webservice.hethongchothuevesi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateResult {
    private int updatedCount;
    private String message;
}
