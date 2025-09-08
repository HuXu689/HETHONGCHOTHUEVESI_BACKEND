package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.VaiTroDTO;
import com.webservice.hethongchothuevesi.entity.VaiTro;
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
public class VaiTroMapperImpl implements VaiTroMapper {

    @Override
    public VaiTroDTO toDTO(VaiTro entity) {
        if ( entity == null ) {
            return null;
        }

        VaiTroDTO.VaiTroDTOBuilder vaiTroDTO = VaiTroDTO.builder();

        vaiTroDTO.idVaiTro( entity.getIdVaiTro() );
        vaiTroDTO.tenVaiTro( entity.getTenVaiTro() );
        vaiTroDTO.capBac( entity.getCapBac() );
        vaiTroDTO.moTa( entity.getMoTa() );

        return vaiTroDTO.build();
    }

    @Override
    public VaiTro toEntity(VaiTroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VaiTro.VaiTroBuilder vaiTro = VaiTro.builder();

        vaiTro.idVaiTro( dto.getIdVaiTro() );
        vaiTro.tenVaiTro( dto.getTenVaiTro() );
        vaiTro.capBac( dto.getCapBac() );
        vaiTro.moTa( dto.getMoTa() );

        return vaiTro.build();
    }

    @Override
    public List<VaiTroDTO> toListDto(List<VaiTro> list) {
        if ( list == null ) {
            return null;
        }

        List<VaiTroDTO> list1 = new ArrayList<VaiTroDTO>( list.size() );
        for ( VaiTro vaiTro : list ) {
            list1.add( toDTO( vaiTro ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(VaiTro entity, VaiTroDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdVaiTro() != null ) {
            entity.setIdVaiTro( dto.getIdVaiTro() );
        }
        if ( dto.getTenVaiTro() != null ) {
            entity.setTenVaiTro( dto.getTenVaiTro() );
        }
        if ( dto.getCapBac() != null ) {
            entity.setCapBac( dto.getCapBac() );
        }
        if ( dto.getMoTa() != null ) {
            entity.setMoTa( dto.getMoTa() );
        }
    }
}
