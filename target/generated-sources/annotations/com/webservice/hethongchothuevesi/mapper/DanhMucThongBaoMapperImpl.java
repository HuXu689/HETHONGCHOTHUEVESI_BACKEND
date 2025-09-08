package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucThongBao;
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
public class DanhMucThongBaoMapperImpl implements DanhMucThongBaoMapper {

    @Override
    public DanhMucThongBaoDTO toDTO(DanhMucThongBao entity) {
        if ( entity == null ) {
            return null;
        }

        DanhMucThongBaoDTO.DanhMucThongBaoDTOBuilder danhMucThongBaoDTO = DanhMucThongBaoDTO.builder();

        danhMucThongBaoDTO.idDanhMucThongBao( entity.getIdDanhMucThongBao() );
        danhMucThongBaoDTO.tenLoaiThongBao( entity.getTenLoaiThongBao() );
        danhMucThongBaoDTO.moTa( entity.getMoTa() );
        danhMucThongBaoDTO.ngayXoa( entity.getNgayXoa() );

        return danhMucThongBaoDTO.build();
    }

    @Override
    public DanhMucThongBao toEntity(DanhMucThongBaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DanhMucThongBao.DanhMucThongBaoBuilder danhMucThongBao = DanhMucThongBao.builder();

        danhMucThongBao.idDanhMucThongBao( dto.getIdDanhMucThongBao() );
        danhMucThongBao.tenLoaiThongBao( dto.getTenLoaiThongBao() );
        danhMucThongBao.moTa( dto.getMoTa() );
        danhMucThongBao.ngayXoa( dto.getNgayXoa() );

        return danhMucThongBao.build();
    }

    @Override
    public List<DanhMucThongBaoDTO> toListDto(List<DanhMucThongBao> list) {
        if ( list == null ) {
            return null;
        }

        List<DanhMucThongBaoDTO> list1 = new ArrayList<DanhMucThongBaoDTO>( list.size() );
        for ( DanhMucThongBao danhMucThongBao : list ) {
            list1.add( toDTO( danhMucThongBao ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(DanhMucThongBao entity, DanhMucThongBaoDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdDanhMucThongBao() != null ) {
            entity.setIdDanhMucThongBao( dto.getIdDanhMucThongBao() );
        }
        if ( dto.getTenLoaiThongBao() != null ) {
            entity.setTenLoaiThongBao( dto.getTenLoaiThongBao() );
        }
        if ( dto.getMoTa() != null ) {
            entity.setMoTa( dto.getMoTa() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
