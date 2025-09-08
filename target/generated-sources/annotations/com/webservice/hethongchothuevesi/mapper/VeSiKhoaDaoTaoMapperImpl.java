package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.VeSiKhoaDaoTao;
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
public class VeSiKhoaDaoTaoMapperImpl implements VeSiKhoaDaoTaoMapper {

    @Override
    public VeSiKhoaDaoTaoDTO toDTO(VeSiKhoaDaoTao entity) {
        if ( entity == null ) {
            return null;
        }

        VeSiKhoaDaoTaoDTO.VeSiKhoaDaoTaoDTOBuilder veSiKhoaDaoTaoDTO = VeSiKhoaDaoTaoDTO.builder();

        veSiKhoaDaoTaoDTO.idVeSiKhoaDaoTao( entity.getIdVeSiKhoaDaoTao() );
        veSiKhoaDaoTaoDTO.idKhoaDaoTao( entity.getIdKhoaDaoTao() );
        veSiKhoaDaoTaoDTO.idVeSi( entity.getIdVeSi() );
        veSiKhoaDaoTaoDTO.ngayHoanThanh( entity.getNgayHoanThanh() );
        veSiKhoaDaoTaoDTO.diem( entity.getDiem() );
        veSiKhoaDaoTaoDTO.chungChi( entity.getChungChi() );
        veSiKhoaDaoTaoDTO.trangThai( entity.getTrangThai() );
        veSiKhoaDaoTaoDTO.ngayXoa( entity.getNgayXoa() );

        return veSiKhoaDaoTaoDTO.build();
    }

    @Override
    public VeSiKhoaDaoTao toEntity(VeSiKhoaDaoTaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VeSiKhoaDaoTao.VeSiKhoaDaoTaoBuilder veSiKhoaDaoTao = VeSiKhoaDaoTao.builder();

        veSiKhoaDaoTao.idVeSiKhoaDaoTao( dto.getIdVeSiKhoaDaoTao() );
        veSiKhoaDaoTao.idKhoaDaoTao( dto.getIdKhoaDaoTao() );
        veSiKhoaDaoTao.idVeSi( dto.getIdVeSi() );
        veSiKhoaDaoTao.ngayHoanThanh( dto.getNgayHoanThanh() );
        veSiKhoaDaoTao.diem( dto.getDiem() );
        veSiKhoaDaoTao.chungChi( dto.getChungChi() );
        veSiKhoaDaoTao.trangThai( dto.getTrangThai() );
        veSiKhoaDaoTao.ngayXoa( dto.getNgayXoa() );

        return veSiKhoaDaoTao.build();
    }

    @Override
    public List<VeSiKhoaDaoTaoDTO> toListDto(List<VeSiKhoaDaoTao> list) {
        if ( list == null ) {
            return null;
        }

        List<VeSiKhoaDaoTaoDTO> list1 = new ArrayList<VeSiKhoaDaoTaoDTO>( list.size() );
        for ( VeSiKhoaDaoTao veSiKhoaDaoTao : list ) {
            list1.add( toDTO( veSiKhoaDaoTao ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(VeSiKhoaDaoTao entity, VeSiKhoaDaoTaoDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdVeSiKhoaDaoTao() != null ) {
            entity.setIdVeSiKhoaDaoTao( dto.getIdVeSiKhoaDaoTao() );
        }
        if ( dto.getIdKhoaDaoTao() != null ) {
            entity.setIdKhoaDaoTao( dto.getIdKhoaDaoTao() );
        }
        if ( dto.getIdVeSi() != null ) {
            entity.setIdVeSi( dto.getIdVeSi() );
        }
        if ( dto.getNgayHoanThanh() != null ) {
            entity.setNgayHoanThanh( dto.getNgayHoanThanh() );
        }
        if ( dto.getDiem() != null ) {
            entity.setDiem( dto.getDiem() );
        }
        if ( dto.getChungChi() != null ) {
            entity.setChungChi( dto.getChungChi() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
