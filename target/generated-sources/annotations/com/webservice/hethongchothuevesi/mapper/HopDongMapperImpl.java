package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.HopDongDTO;
import com.webservice.hethongchothuevesi.entity.HopDong;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T19:01:14+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class HopDongMapperImpl implements HopDongMapper {

    @Override
    public HopDongDTO toDTO(HopDong entity) {
        if ( entity == null ) {
            return null;
        }

        HopDongDTO.HopDongDTOBuilder hopDongDTO = HopDongDTO.builder();

        hopDongDTO.idHopDong( entity.getIdHopDong() );
        hopDongDTO.idYeuCauDichVu( entity.getIdYeuCauDichVu() );
        hopDongDTO.hoTenKhachHang( entity.getHoTenKhachHang() );
        hopDongDTO.soDienThoai( entity.getSoDienThoai() );
        hopDongDTO.idAnh( entity.getIdAnh() );
        hopDongDTO.anh( entity.getAnh() );
        hopDongDTO.soCccd( entity.getSoCccd() );
        hopDongDTO.diaDiem( entity.getDiaDiem() );
        hopDongDTO.soLuongVeSi( entity.getSoLuongVeSi() );
        hopDongDTO.thoiGianBatDau( entity.getThoiGianBatDau() );
        hopDongDTO.thoiGianKetThuc( entity.getThoiGianKetThuc() );
        hopDongDTO.tongChiPhi( entity.getTongChiPhi() );
        hopDongDTO.ghiChu( entity.getGhiChu() );
        hopDongDTO.soSaoDanhGia( entity.getSoSaoDanhGia() );
        hopDongDTO.thongTinDanhGia( entity.getThongTinDanhGia() );
        hopDongDTO.trangThai( entity.getTrangThai() );
        hopDongDTO.ngayXoa( entity.getNgayXoa() );

        return hopDongDTO.build();
    }

    @Override
    public HopDong toEntity(HopDongDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HopDong.HopDongBuilder hopDong = HopDong.builder();

        hopDong.idHopDong( dto.getIdHopDong() );
        hopDong.idYeuCauDichVu( dto.getIdYeuCauDichVu() );
        hopDong.hoTenKhachHang( dto.getHoTenKhachHang() );
        hopDong.soDienThoai( dto.getSoDienThoai() );
        hopDong.idAnh( dto.getIdAnh() );
        hopDong.anh( dto.getAnh() );
        hopDong.soCccd( dto.getSoCccd() );
        hopDong.diaDiem( dto.getDiaDiem() );
        hopDong.soLuongVeSi( dto.getSoLuongVeSi() );
        hopDong.thoiGianBatDau( dto.getThoiGianBatDau() );
        hopDong.thoiGianKetThuc( dto.getThoiGianKetThuc() );
        hopDong.tongChiPhi( dto.getTongChiPhi() );
        hopDong.ghiChu( dto.getGhiChu() );
        hopDong.soSaoDanhGia( dto.getSoSaoDanhGia() );
        hopDong.thongTinDanhGia( dto.getThongTinDanhGia() );
        hopDong.trangThai( dto.getTrangThai() );
        hopDong.ngayXoa( dto.getNgayXoa() );

        return hopDong.build();
    }

    @Override
    public List<HopDongDTO> toListDto(List<HopDong> list) {
        if ( list == null ) {
            return null;
        }

        List<HopDongDTO> list1 = new ArrayList<HopDongDTO>( list.size() );
        for ( HopDong hopDong : list ) {
            list1.add( toDTO( hopDong ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(HopDong entity, HopDongDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdHopDong() != null ) {
            entity.setIdHopDong( dto.getIdHopDong() );
        }
        if ( dto.getIdYeuCauDichVu() != null ) {
            entity.setIdYeuCauDichVu( dto.getIdYeuCauDichVu() );
        }
        if ( dto.getHoTenKhachHang() != null ) {
            entity.setHoTenKhachHang( dto.getHoTenKhachHang() );
        }
        if ( dto.getSoDienThoai() != null ) {
            entity.setSoDienThoai( dto.getSoDienThoai() );
        }
        if ( dto.getIdAnh() != null ) {
            entity.setIdAnh( dto.getIdAnh() );
        }
        if ( dto.getAnh() != null ) {
            entity.setAnh( dto.getAnh() );
        }
        if ( dto.getSoCccd() != null ) {
            entity.setSoCccd( dto.getSoCccd() );
        }
        if ( dto.getDiaDiem() != null ) {
            entity.setDiaDiem( dto.getDiaDiem() );
        }
        if ( dto.getSoLuongVeSi() != null ) {
            entity.setSoLuongVeSi( dto.getSoLuongVeSi() );
        }
        if ( dto.getThoiGianBatDau() != null ) {
            entity.setThoiGianBatDau( dto.getThoiGianBatDau() );
        }
        if ( dto.getThoiGianKetThuc() != null ) {
            entity.setThoiGianKetThuc( dto.getThoiGianKetThuc() );
        }
        if ( dto.getTongChiPhi() != null ) {
            entity.setTongChiPhi( dto.getTongChiPhi() );
        }
        if ( dto.getGhiChu() != null ) {
            entity.setGhiChu( dto.getGhiChu() );
        }
        if ( dto.getSoSaoDanhGia() != null ) {
            entity.setSoSaoDanhGia( dto.getSoSaoDanhGia() );
        }
        if ( dto.getThongTinDanhGia() != null ) {
            entity.setThongTinDanhGia( dto.getThongTinDanhGia() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
