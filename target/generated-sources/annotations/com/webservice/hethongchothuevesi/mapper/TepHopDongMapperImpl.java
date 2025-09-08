package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.TepHopDongDTO;
import com.webservice.hethongchothuevesi.entity.TepHopDong;
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
public class TepHopDongMapperImpl implements TepHopDongMapper {

    @Override
    public TepHopDongDTO toDTO(TepHopDong entity) {
        if ( entity == null ) {
            return null;
        }

        TepHopDongDTO.TepHopDongDTOBuilder tepHopDongDTO = TepHopDongDTO.builder();

        tepHopDongDTO.idTepHopDong( entity.getIdTepHopDong() );
        tepHopDongDTO.idHopDong( entity.getIdHopDong() );
        tepHopDongDTO.loaiTep( entity.getLoaiTep() );
        tepHopDongDTO.tepDinhKem( entity.getTepDinhKem() );

        return tepHopDongDTO.build();
    }

    @Override
    public TepHopDong toEntity(TepHopDongDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TepHopDong.TepHopDongBuilder tepHopDong = TepHopDong.builder();

        tepHopDong.idTepHopDong( dto.getIdTepHopDong() );
        tepHopDong.idHopDong( dto.getIdHopDong() );
        tepHopDong.loaiTep( dto.getLoaiTep() );
        tepHopDong.tepDinhKem( dto.getTepDinhKem() );

        return tepHopDong.build();
    }

    @Override
    public List<TepHopDongDTO> toListDto(List<TepHopDong> list) {
        if ( list == null ) {
            return null;
        }

        List<TepHopDongDTO> list1 = new ArrayList<TepHopDongDTO>( list.size() );
        for ( TepHopDong tepHopDong : list ) {
            list1.add( toDTO( tepHopDong ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(TepHopDong entity, TepHopDongDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdTepHopDong() != null ) {
            entity.setIdTepHopDong( dto.getIdTepHopDong() );
        }
        if ( dto.getIdHopDong() != null ) {
            entity.setIdHopDong( dto.getIdHopDong() );
        }
        if ( dto.getLoaiTep() != null ) {
            entity.setLoaiTep( dto.getLoaiTep() );
        }
        if ( dto.getTepDinhKem() != null ) {
            entity.setTepDinhKem( dto.getTepDinhKem() );
        }
    }
}
