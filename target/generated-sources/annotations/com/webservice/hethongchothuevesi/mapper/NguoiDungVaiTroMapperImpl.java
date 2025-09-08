package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.NguoiDungVaiTroDTO;
import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
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
public class NguoiDungVaiTroMapperImpl implements NguoiDungVaiTroMapper {

    @Override
    public NguoiDungVaiTroDTO toDTO(NguoiDungVaiTro entity) {
        if ( entity == null ) {
            return null;
        }

        NguoiDungVaiTroDTO.NguoiDungVaiTroDTOBuilder nguoiDungVaiTroDTO = NguoiDungVaiTroDTO.builder();

        nguoiDungVaiTroDTO.idNguoiDungVaiTro( entity.getIdNguoiDungVaiTro() );
        nguoiDungVaiTroDTO.idNguoiDung( entity.getIdNguoiDung() );
        nguoiDungVaiTroDTO.idVaiTro( entity.getIdVaiTro() );

        return nguoiDungVaiTroDTO.build();
    }

    @Override
    public NguoiDungVaiTro toEntity(NguoiDungVaiTroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        NguoiDungVaiTro.NguoiDungVaiTroBuilder nguoiDungVaiTro = NguoiDungVaiTro.builder();

        nguoiDungVaiTro.idNguoiDungVaiTro( dto.getIdNguoiDungVaiTro() );
        nguoiDungVaiTro.idNguoiDung( dto.getIdNguoiDung() );
        nguoiDungVaiTro.idVaiTro( dto.getIdVaiTro() );

        return nguoiDungVaiTro.build();
    }

    @Override
    public List<NguoiDungVaiTroDTO> toListDto(List<NguoiDungVaiTro> list) {
        if ( list == null ) {
            return null;
        }

        List<NguoiDungVaiTroDTO> list1 = new ArrayList<NguoiDungVaiTroDTO>( list.size() );
        for ( NguoiDungVaiTro nguoiDungVaiTro : list ) {
            list1.add( toDTO( nguoiDungVaiTro ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(NguoiDungVaiTro entity, NguoiDungVaiTroDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdNguoiDungVaiTro() != null ) {
            entity.setIdNguoiDungVaiTro( dto.getIdNguoiDungVaiTro() );
        }
        if ( dto.getIdNguoiDung() != null ) {
            entity.setIdNguoiDung( dto.getIdNguoiDung() );
        }
        if ( dto.getIdVaiTro() != null ) {
            entity.setIdVaiTro( dto.getIdVaiTro() );
        }
    }
}
