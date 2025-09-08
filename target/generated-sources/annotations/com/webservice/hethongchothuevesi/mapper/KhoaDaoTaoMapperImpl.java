package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.KhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.KhoaDaoTao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T19:01:13+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class KhoaDaoTaoMapperImpl implements KhoaDaoTaoMapper {

    @Override
    public KhoaDaoTaoDTO toDTO(KhoaDaoTao entity) {
        if ( entity == null ) {
            return null;
        }

        KhoaDaoTaoDTO.KhoaDaoTaoDTOBuilder khoaDaoTaoDTO = KhoaDaoTaoDTO.builder();

        khoaDaoTaoDTO.idKhoaDaoTao( entity.getIdKhoaDaoTao() );
        khoaDaoTaoDTO.idDanhMucKhoaDaoTao( entity.getIdDanhMucKhoaDaoTao() );
        khoaDaoTaoDTO.tenKhoaDaoTao( entity.getTenKhoaDaoTao() );
        khoaDaoTaoDTO.diaDiem( entity.getDiaDiem() );
        khoaDaoTaoDTO.ngayBatDau( entity.getNgayBatDau() );
        khoaDaoTaoDTO.ngayKetThuc( entity.getNgayKetThuc() );
        khoaDaoTaoDTO.moTa( entity.getMoTa() );
        khoaDaoTaoDTO.trangThai( entity.getTrangThai() );
        khoaDaoTaoDTO.ngayXoa( entity.getNgayXoa() );

        return khoaDaoTaoDTO.build();
    }

    @Override
    public KhoaDaoTao toEntity(KhoaDaoTaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        KhoaDaoTao.KhoaDaoTaoBuilder khoaDaoTao = KhoaDaoTao.builder();

        khoaDaoTao.idKhoaDaoTao( dto.getIdKhoaDaoTao() );
        khoaDaoTao.idDanhMucKhoaDaoTao( dto.getIdDanhMucKhoaDaoTao() );
        khoaDaoTao.tenKhoaDaoTao( dto.getTenKhoaDaoTao() );
        khoaDaoTao.diaDiem( dto.getDiaDiem() );
        khoaDaoTao.ngayBatDau( dto.getNgayBatDau() );
        khoaDaoTao.ngayKetThuc( dto.getNgayKetThuc() );
        khoaDaoTao.moTa( dto.getMoTa() );
        khoaDaoTao.trangThai( dto.getTrangThai() );
        khoaDaoTao.ngayXoa( dto.getNgayXoa() );

        return khoaDaoTao.build();
    }

    @Override
    public List<KhoaDaoTaoDTO> toListDto(List<KhoaDaoTao> list) {
        if ( list == null ) {
            return null;
        }

        List<KhoaDaoTaoDTO> list1 = new ArrayList<KhoaDaoTaoDTO>( list.size() );
        for ( KhoaDaoTao khoaDaoTao : list ) {
            list1.add( toDTO( khoaDaoTao ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(KhoaDaoTao entity, KhoaDaoTaoDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdKhoaDaoTao() != null ) {
            entity.setIdKhoaDaoTao( dto.getIdKhoaDaoTao() );
        }
        if ( dto.getIdDanhMucKhoaDaoTao() != null ) {
            entity.setIdDanhMucKhoaDaoTao( dto.getIdDanhMucKhoaDaoTao() );
        }
        if ( dto.getTenKhoaDaoTao() != null ) {
            entity.setTenKhoaDaoTao( dto.getTenKhoaDaoTao() );
        }
        if ( dto.getDiaDiem() != null ) {
            entity.setDiaDiem( dto.getDiaDiem() );
        }
        if ( dto.getNgayBatDau() != null ) {
            entity.setNgayBatDau( dto.getNgayBatDau() );
        }
        if ( dto.getNgayKetThuc() != null ) {
            entity.setNgayKetThuc( dto.getNgayKetThuc() );
        }
        if ( dto.getMoTa() != null ) {
            entity.setMoTa( dto.getMoTa() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
