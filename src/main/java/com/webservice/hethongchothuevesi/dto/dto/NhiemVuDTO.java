package com.webservice.hethongchothuevesi.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhiemVuDTO {
    private Integer idNhiemVu;
    private Integer idHopDong;
    private Integer idVeSi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate ngayBatDau;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate ngayKetThuc;

    private String capBac;
    private String noiDung;
    private Integer danhGiaKyNangChuyenMon;
    private Integer danhGiaXuLyTinhHuong;
    private Integer danhGiaThaiDoDaoDuc;
    private Integer danhGiaGiaoTiep;
    private Integer danhGiaNgoaiHinh;
    private String thongTinDanhGia;
    private String trangThai;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ngayXoa;

    // Tính soSao trung bình từ các trường đánh giá
    @JsonProperty("soSao")
    public Double getSoSao() {
        int sum = 0;
        int count = 0;

        if (danhGiaKyNangChuyenMon != null) {
            sum += danhGiaKyNangChuyenMon;
            count++;
        }
        if (danhGiaXuLyTinhHuong != null) {
            sum += danhGiaXuLyTinhHuong;
            count++;
        }
        if (danhGiaThaiDoDaoDuc != null) {
            sum += danhGiaThaiDoDaoDuc;
            count++;
        }
        if (danhGiaGiaoTiep != null) {
            sum += danhGiaGiaoTiep;
            count++;
        }
        if (danhGiaNgoaiHinh != null) {
            sum += danhGiaNgoaiHinh;
            count++;
        }

        return count > 0 ? (double) sum / count : null; // Trả về null nếu không có giá trị đánh giá
    }
}
