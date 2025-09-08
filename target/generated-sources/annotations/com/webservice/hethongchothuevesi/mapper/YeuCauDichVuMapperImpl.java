package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
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
public class YeuCauDichVuMapperImpl implements YeuCauDichVuMapper {

    @Override
    public YeuCauDichVuDTO toDTO(YeuCauDichVu entity) {
        if ( entity == null ) {
            return null;
        }

        YeuCauDichVuDTO.YeuCauDichVuDTOBuilder yeuCauDichVuDTO = YeuCauDichVuDTO.builder();

        yeuCauDichVuDTO.idYeuCauDichVu( entity.getIdYeuCauDichVu() );
        yeuCauDichVuDTO.idNguoiDung( entity.getIdNguoiDung() );
        yeuCauDichVuDTO.idDanhMucDichVu( entity.getIdDanhMucDichVu() );
        yeuCauDichVuDTO.hoTenKhachHang( entity.getHoTenKhachHang() );
        yeuCauDichVuDTO.soDienThoai( entity.getSoDienThoai() );
        yeuCauDichVuDTO.idAnh( entity.getIdAnh() );
        yeuCauDichVuDTO.anh( entity.getAnh() );
        yeuCauDichVuDTO.soCccd( entity.getSoCccd() );
        yeuCauDichVuDTO.diaDiem( entity.getDiaDiem() );
        yeuCauDichVuDTO.soLuongVeSi( entity.getSoLuongVeSi() );
        yeuCauDichVuDTO.ngayBatDau( entity.getNgayBatDau() );
        yeuCauDichVuDTO.ngayKetThuc( entity.getNgayKetThuc() );
        yeuCauDichVuDTO.giaTienDuKien( entity.getGiaTienDuKien() );
        yeuCauDichVuDTO.ghiChu( entity.getGhiChu() );
        yeuCauDichVuDTO.noiDungTraLoi( entity.getNoiDungTraLoi() );
        yeuCauDichVuDTO.trangThai( entity.getTrangThai() );
        yeuCauDichVuDTO.ngayXoa( entity.getNgayXoa() );

        return yeuCauDichVuDTO.build();
    }

    @Override
    public YeuCauDichVu toEntity(YeuCauDichVuDTO dto) {
        if ( dto == null ) {
            return null;
        }

        YeuCauDichVu.YeuCauDichVuBuilder yeuCauDichVu = YeuCauDichVu.builder();

        yeuCauDichVu.idYeuCauDichVu( dto.getIdYeuCauDichVu() );
        yeuCauDichVu.idNguoiDung( dto.getIdNguoiDung() );
        yeuCauDichVu.idDanhMucDichVu( dto.getIdDanhMucDichVu() );
        yeuCauDichVu.hoTenKhachHang( dto.getHoTenKhachHang() );
        yeuCauDichVu.soDienThoai( dto.getSoDienThoai() );
        yeuCauDichVu.idAnh( dto.getIdAnh() );
        yeuCauDichVu.anh( dto.getAnh() );
        yeuCauDichVu.soCccd( dto.getSoCccd() );
        yeuCauDichVu.diaDiem( dto.getDiaDiem() );
        yeuCauDichVu.soLuongVeSi( dto.getSoLuongVeSi() );
        yeuCauDichVu.ngayBatDau( dto.getNgayBatDau() );
        yeuCauDichVu.ngayKetThuc( dto.getNgayKetThuc() );
        yeuCauDichVu.giaTienDuKien( dto.getGiaTienDuKien() );
        yeuCauDichVu.ghiChu( dto.getGhiChu() );
        yeuCauDichVu.noiDungTraLoi( dto.getNoiDungTraLoi() );
        yeuCauDichVu.trangThai( dto.getTrangThai() );
        yeuCauDichVu.ngayXoa( dto.getNgayXoa() );

        return yeuCauDichVu.build();
    }

    @Override
    public List<YeuCauDichVuDTO> toListDto(List<YeuCauDichVu> list) {
        if ( list == null ) {
            return null;
        }

        List<YeuCauDichVuDTO> list1 = new ArrayList<YeuCauDichVuDTO>( list.size() );
        for ( YeuCauDichVu yeuCauDichVu : list ) {
            list1.add( toDTO( yeuCauDichVu ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(YeuCauDichVu entity, YeuCauDichVuDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdYeuCauDichVu() != null ) {
            entity.setIdYeuCauDichVu( dto.getIdYeuCauDichVu() );
        }
        if ( dto.getIdNguoiDung() != null ) {
            entity.setIdNguoiDung( dto.getIdNguoiDung() );
        }
        if ( dto.getIdDanhMucDichVu() != null ) {
            entity.setIdDanhMucDichVu( dto.getIdDanhMucDichVu() );
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
        if ( dto.getNgayBatDau() != null ) {
            entity.setNgayBatDau( dto.getNgayBatDau() );
        }
        if ( dto.getNgayKetThuc() != null ) {
            entity.setNgayKetThuc( dto.getNgayKetThuc() );
        }
        if ( dto.getGiaTienDuKien() != null ) {
            entity.setGiaTienDuKien( dto.getGiaTienDuKien() );
        }
        if ( dto.getGhiChu() != null ) {
            entity.setGhiChu( dto.getGhiChu() );
        }
        if ( dto.getNoiDungTraLoi() != null ) {
            entity.setNoiDungTraLoi( dto.getNoiDungTraLoi() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
