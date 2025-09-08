package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.LichSuHoatDongDTO;
import com.webservice.hethongchothuevesi.entity.LichSuHoatDong;
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
public class LichSuHoatDongMapperImpl implements LichSuHoatDongMapper {

    @Override
    public LichSuHoatDongDTO toDTO(LichSuHoatDong entity) {
        if ( entity == null ) {
            return null;
        }

        LichSuHoatDongDTO.LichSuHoatDongDTOBuilder lichSuHoatDongDTO = LichSuHoatDongDTO.builder();

        lichSuHoatDongDTO.idLichSuHoatDong( entity.getIdLichSuHoatDong() );
        lichSuHoatDongDTO.idNguoiDung( entity.getIdNguoiDung() );
        lichSuHoatDongDTO.idDoiTuong( entity.getIdDoiTuong() );
        lichSuHoatDongDTO.loaiDoiTuong( entity.getLoaiDoiTuong() );
        lichSuHoatDongDTO.thoiGianThucHien( entity.getThoiGianThucHien() );
        lichSuHoatDongDTO.hoatDong( entity.getHoatDong() );
        lichSuHoatDongDTO.thongTinHoatDong( entity.getThongTinHoatDong() );

        return lichSuHoatDongDTO.build();
    }

    @Override
    public LichSuHoatDong toEntity(LichSuHoatDongDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LichSuHoatDong.LichSuHoatDongBuilder lichSuHoatDong = LichSuHoatDong.builder();

        lichSuHoatDong.idLichSuHoatDong( dto.getIdLichSuHoatDong() );
        lichSuHoatDong.idNguoiDung( dto.getIdNguoiDung() );
        lichSuHoatDong.idDoiTuong( dto.getIdDoiTuong() );
        lichSuHoatDong.loaiDoiTuong( dto.getLoaiDoiTuong() );
        lichSuHoatDong.thoiGianThucHien( dto.getThoiGianThucHien() );
        lichSuHoatDong.hoatDong( dto.getHoatDong() );
        lichSuHoatDong.thongTinHoatDong( dto.getThongTinHoatDong() );

        return lichSuHoatDong.build();
    }

    @Override
    public List<LichSuHoatDongDTO> toListDto(List<LichSuHoatDong> list) {
        if ( list == null ) {
            return null;
        }

        List<LichSuHoatDongDTO> list1 = new ArrayList<LichSuHoatDongDTO>( list.size() );
        for ( LichSuHoatDong lichSuHoatDong : list ) {
            list1.add( toDTO( lichSuHoatDong ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(LichSuHoatDong entity, LichSuHoatDongDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdLichSuHoatDong() != null ) {
            entity.setIdLichSuHoatDong( dto.getIdLichSuHoatDong() );
        }
        if ( dto.getIdNguoiDung() != null ) {
            entity.setIdNguoiDung( dto.getIdNguoiDung() );
        }
        if ( dto.getIdDoiTuong() != null ) {
            entity.setIdDoiTuong( dto.getIdDoiTuong() );
        }
        if ( dto.getLoaiDoiTuong() != null ) {
            entity.setLoaiDoiTuong( dto.getLoaiDoiTuong() );
        }
        if ( dto.getThoiGianThucHien() != null ) {
            entity.setThoiGianThucHien( dto.getThoiGianThucHien() );
        }
        if ( dto.getHoatDong() != null ) {
            entity.setHoatDong( dto.getHoatDong() );
        }
        if ( dto.getThongTinHoatDong() != null ) {
            entity.setThongTinHoatDong( dto.getThongTinHoatDong() );
        }
    }
}
