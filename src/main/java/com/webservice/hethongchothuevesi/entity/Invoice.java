package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invoice {

    @Id
    private String idHoaDon;
    private String trangThai;
    private long giaTien;
    private String description;
    // Các trường khác...
}
