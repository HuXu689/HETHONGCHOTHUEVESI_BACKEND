package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucKhoaDaoTao;
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
public class DanhMucKhoaDaoTaoMapperImpl implements DanhMucKhoaDaoTaoMapper {

    @Override
    public DanhMucKhoaDaoTaoDTO toDTO(DanhMucKhoaDaoTao entity) {
        if ( entity == null ) {
            return null;
        }

        DanhMucKhoaDaoTaoDTO.DanhMucKhoaDaoTaoDTOBuilder danhMucKhoaDaoTaoDTO = DanhMucKhoaDaoTaoDTO.builder();

        danhMucKhoaDaoTaoDTO.idDanhMucKhoaDaoTao( entity.getIdDanhMucKhoaDaoTao() );
        danhMucKhoaDaoTaoDTO.tenKhoaDaoTao( entity.getTenKhoaDaoTao() );
        danhMucKhoaDaoTaoDTO.moTa( entity.getMoTa() );
        danhMucKhoaDaoTaoDTO.ngayXoa( entity.getNgayXoa() );

        return danhMucKhoaDaoTaoDTO.build();
    }

    @Override
    public DanhMucKhoaDaoTao toEntity(DanhMucKhoaDaoTaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DanhMucKhoaDaoTao.DanhMucKhoaDaoTaoBuilder danhMucKhoaDaoTao = DanhMucKhoaDaoTao.builder();

        danhMucKhoaDaoTao.idDanhMucKhoaDaoTao( dto.getIdDanhMucKhoaDaoTao() );
        danhMucKhoaDaoTao.tenKhoaDaoTao( dto.getTenKhoaDaoTao() );
        danhMucKhoaDaoTao.moTa( dto.getMoTa() );
        danhMucKhoaDaoTao.ngayXoa( dto.getNgayXoa() );

        return danhMucKhoaDaoTao.build();
    }

    @Override
    public List<DanhMucKhoaDaoTaoDTO> toListDto(List<DanhMucKhoaDaoTao> list) {
        if ( list == null ) {
            return null;
        }

        List<DanhMucKhoaDaoTaoDTO> list1 = new ArrayList<DanhMucKhoaDaoTaoDTO>( list.size() );
        for ( DanhMucKhoaDaoTao danhMucKhoaDaoTao : list ) {
            list1.add( toDTO( danhMucKhoaDaoTao ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(DanhMucKhoaDaoTao entity, DanhMucKhoaDaoTaoDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdDanhMucKhoaDaoTao() != null ) {
            entity.setIdDanhMucKhoaDaoTao( dto.getIdDanhMucKhoaDaoTao() );
        }
        if ( dto.getTenKhoaDaoTao() != null ) {
            entity.setTenKhoaDaoTao( dto.getTenKhoaDaoTao() );
        }
        if ( dto.getMoTa() != null ) {
            entity.setMoTa( dto.getMoTa() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
