package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.VeSiDTO;
import com.webservice.hethongchothuevesi.entity.VeSi;
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
public class VeSiMapperImpl implements VeSiMapper {

    @Override
    public VeSiDTO toDTO(VeSi entity) {
        if ( entity == null ) {
            return null;
        }

        VeSiDTO.VeSiDTOBuilder veSiDTO = VeSiDTO.builder();

        veSiDTO.idVeSi( entity.getIdVeSi() );
        veSiDTO.idNguoiDung( entity.getIdNguoiDung() );
        veSiDTO.kinhNghiem( entity.getKinhNghiem() );
        veSiDTO.thongTinDanhGiaChung( entity.getThongTinDanhGiaChung() );
        veSiDTO.ngayBatDauLam( entity.getNgayBatDauLam() );
        veSiDTO.capBac( entity.getCapBac() );
        veSiDTO.ngayLenCap( entity.getNgayLenCap() );
        veSiDTO.luong( entity.getLuong() );
        veSiDTO.trangThai( entity.getTrangThai() );
        veSiDTO.ngayXoa( entity.getNgayXoa() );

        return veSiDTO.build();
    }

    @Override
    public VeSi toEntity(VeSiDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VeSi.VeSiBuilder veSi = VeSi.builder();

        veSi.idVeSi( dto.getIdVeSi() );
        veSi.idNguoiDung( dto.getIdNguoiDung() );
        veSi.kinhNghiem( dto.getKinhNghiem() );
        veSi.thongTinDanhGiaChung( dto.getThongTinDanhGiaChung() );
        veSi.ngayBatDauLam( dto.getNgayBatDauLam() );
        veSi.capBac( dto.getCapBac() );
        veSi.ngayLenCap( dto.getNgayLenCap() );
        veSi.luong( dto.getLuong() );
        veSi.trangThai( dto.getTrangThai() );
        veSi.ngayXoa( dto.getNgayXoa() );

        return veSi.build();
    }

    @Override
    public List<VeSiDTO> toListDto(List<VeSi> list) {
        if ( list == null ) {
            return null;
        }

        List<VeSiDTO> list1 = new ArrayList<VeSiDTO>( list.size() );
        for ( VeSi veSi : list ) {
            list1.add( toDTO( veSi ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(VeSi entity, VeSiDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdVeSi() != null ) {
            entity.setIdVeSi( dto.getIdVeSi() );
        }
        if ( dto.getIdNguoiDung() != null ) {
            entity.setIdNguoiDung( dto.getIdNguoiDung() );
        }
        if ( dto.getKinhNghiem() != null ) {
            entity.setKinhNghiem( dto.getKinhNghiem() );
        }
        if ( dto.getThongTinDanhGiaChung() != null ) {
            entity.setThongTinDanhGiaChung( dto.getThongTinDanhGiaChung() );
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
