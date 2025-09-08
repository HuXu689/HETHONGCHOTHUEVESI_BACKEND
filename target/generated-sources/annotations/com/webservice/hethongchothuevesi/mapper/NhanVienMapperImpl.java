package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.NhanVienDTO;
import com.webservice.hethongchothuevesi.entity.NhanVien;
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
public class NhanVienMapperImpl implements NhanVienMapper {

    @Override
    public NhanVienDTO toDTO(NhanVien nhanVien) {
        if ( nhanVien == null ) {
            return null;
        }

        NhanVienDTO.NhanVienDTOBuilder nhanVienDTO = NhanVienDTO.builder();

        nhanVienDTO.idNhanVien( nhanVien.getIdNhanVien() );
        nhanVienDTO.idNguoiDung( nhanVien.getIdNguoiDung() );
        nhanVienDTO.ngayBatDauLam( nhanVien.getNgayBatDauLam() );
        nhanVienDTO.capBac( nhanVien.getCapBac() );
        nhanVienDTO.ngayLenCap( nhanVien.getNgayLenCap() );
        nhanVienDTO.luong( nhanVien.getLuong() );
        nhanVienDTO.trangThai( nhanVien.getTrangThai() );
        nhanVienDTO.ngayXoa( nhanVien.getNgayXoa() );

        return nhanVienDTO.build();
    }

    @Override
    public NhanVien toEntity(NhanVienDTO nhanVienDTO) {
        if ( nhanVienDTO == null ) {
            return null;
        }

        NhanVien.NhanVienBuilder nhanVien = NhanVien.builder();

        nhanVien.idNhanVien( nhanVienDTO.getIdNhanVien() );
        nhanVien.idNguoiDung( nhanVienDTO.getIdNguoiDung() );
        nhanVien.ngayBatDauLam( nhanVienDTO.getNgayBatDauLam() );
        nhanVien.capBac( nhanVienDTO.getCapBac() );
        nhanVien.ngayLenCap( nhanVienDTO.getNgayLenCap() );
        nhanVien.luong( nhanVienDTO.getLuong() );
        nhanVien.trangThai( nhanVienDTO.getTrangThai() );
        nhanVien.ngayXoa( nhanVienDTO.getNgayXoa() );

        return nhanVien.build();
    }

    @Override
    public List<NhanVienDTO> toListDto(List<NhanVien> list) {
        if ( list == null ) {
            return null;
        }

        List<NhanVienDTO> list1 = new ArrayList<NhanVienDTO>( list.size() );
        for ( NhanVien nhanVien : list ) {
            list1.add( toDTO( nhanVien ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(NhanVien entity, NhanVienDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdNhanVien() != null ) {
            entity.setIdNhanVien( dto.getIdNhanVien() );
        }
        if ( dto.getIdNguoiDung() != null ) {
            entity.setIdNguoiDung( dto.getIdNguoiDung() );
        }
        if ( dto.getNgayBatDauLam() != null ) {
            entity.setNgayBatDauLam( dto.getNgayBatDauLam() );
        }
        if ( dto.getCapBac() != null ) {
            entity.setCapBac( dto.getCapBac() );
        }
        if ( dto.getNgayLenCap() != null ) {
            entity.setNgayLenCap( dto.getNgayLenCap() );
        }
        if ( dto.getLuong() != null ) {
            entity.setLuong( dto.getLuong() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
