package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "DanhMucDichVu")
public class DanhMucDichVu {
    @Id
    @Column(name = "idDanhMucDichVu")
    private Integer idDanhMucDichVu;

    @Column(name = "tenDichVu")
    private String tenDichVu;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "giaDuKien")
    private BigDecimal giaDuKien;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;
}
