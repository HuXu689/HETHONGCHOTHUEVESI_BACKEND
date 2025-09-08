package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauHoTroDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauHoTro;
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
public class YeuCauHoTroMapperImpl implements YeuCauHoTroMapper {

    @Override
    public YeuCauHoTroDTO toDTO(YeuCauHoTro entity) {
        if ( entity == null ) {
            return null;
        }

        YeuCauHoTroDTO.YeuCauHoTroDTOBuilder yeuCauHoTroDTO = YeuCauHoTroDTO.builder();

        yeuCauHoTroDTO.idYeuCauHoTro( entity.getIdYeuCauHoTro() );
        yeuCauHoTroDTO.idNhanVien( entity.getIdNhanVien() );
        yeuCauHoTroDTO.idNguoiDung( entity.getIdNguoiDung() );
        yeuCauHoTroDTO.loaiYeuCau( entity.getLoaiYeuCau() );
        yeuCauHoTroDTO.noiDungYeuCau( entity.getNoiDungYeuCau() );
        yeuCauHoTroDTO.tepDinhKem( entity.getTepDinhKem() );
        yeuCauHoTroDTO.noiDungPhanHoi( entity.getNoiDungPhanHoi() );
        yeuCauHoTroDTO.trangThai( entity.getTrangThai() );
        yeuCauHoTroDTO.ngayXoa( entity.getNgayXoa() );

        return yeuCauHoTroDTO.build();
    }

    @Override
    public YeuCauHoTro toEntity(YeuCauHoTroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        YeuCauHoTro.YeuCauHoTroBuilder yeuCauHoTro = YeuCauHoTro.builder();

        yeuCauHoTro.idYeuCauHoTro( dto.getIdYeuCauHoTro() );
        yeuCauHoTro.idNhanVien( dto.getIdNhanVien() );
        yeuCauHoTro.idNguoiDung( dto.getIdNguoiDung() );
        yeuCauHoTro.loaiYeuCau( dto.getLoaiYeuCau() );
        yeuCauHoTro.noiDungYeuCau( dto.getNoiDungYeuCau() );
        yeuCauHoTro.tepDinhKem( dto.getTepDinhKem() );
        yeuCauHoTro.noiDungPhanHoi( dto.getNoiDungPhanHoi() );
        yeuCauHoTro.trangThai( dto.getTrangThai() );
        yeuCauHoTro.ngayXoa( dto.getNgayXoa() );

        return yeuCauHoTro.build();
    }

    @Override
    public List<YeuCauHoTroDTO> toListDto(List<YeuCauHoTro> list) {
        if ( list == null ) {
            return null;
        }

        List<YeuCauHoTroDTO> list1 = new ArrayList<YeuCauHoTroDTO>( list.size() );
        for ( YeuCauHoTro yeuCauHoTro : list ) {
            list1.add( toDTO( yeuCauHoTro ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(YeuCauHoTro entity, YeuCauHoTroDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdYeuCauHoTro() != null ) {
            entity.setIdYeuCauHoTro( dto.getIdYeuCauHoTro() );
        }
        if ( dto.getIdNhanVien() != null ) {
            entity.setIdNhanVien( dto.getIdNhanVien() );
        }
        if ( dto.getIdNguoiDung() != null ) {
            entity.setIdNguoiDung( dto.getIdNguoiDung() );
        }
        if ( dto.getLoaiYeuCau() != null ) {
            entity.setLoaiYeuCau( dto.getLoaiYeuCau() );
        }
        if ( dto.getNoiDungYeuCau() != null ) {
            entity.setNoiDungYeuCau( dto.getNoiDungYeuCau() );
        }
        if ( dto.getTepDinhKem() != null ) {
            entity.setTepDinhKem( dto.getTepDinhKem() );
        }
        if ( dto.getNoiDungPhanHoi() != null ) {
            entity.setNoiDungPhanHoi( dto.getNoiDungPhanHoi() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
