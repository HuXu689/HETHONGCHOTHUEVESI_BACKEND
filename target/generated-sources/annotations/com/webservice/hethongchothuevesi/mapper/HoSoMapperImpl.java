package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.HoSoDTO;
import com.webservice.hethongchothuevesi.entity.HoSo;
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
public class HoSoMapperImpl implements HoSoMapper {

    @Override
    public HoSoDTO toDTO(HoSo entity) {
        if ( entity == null ) {
            return null;
        }

        HoSoDTO.HoSoDTOBuilder hoSoDTO = HoSoDTO.builder();

        hoSoDTO.idHoSo( entity.getIdHoSo() );
        hoSoDTO.idVeSi( entity.getIdVeSi() );
        hoSoDTO.loaiHoSo( entity.getLoaiHoSo() );
        hoSoDTO.tepDinhKem( entity.getTepDinhKem() );
        hoSoDTO.ngayXoa( entity.getNgayXoa() );

        return hoSoDTO.build();
    }

    @Override
    public HoSo toEntity(HoSoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HoSo.HoSoBuilder hoSo = HoSo.builder();

        hoSo.idHoSo( dto.getIdHoSo() );
        hoSo.idVeSi( dto.getIdVeSi() );
        hoSo.loaiHoSo( dto.getLoaiHoSo() );
        hoSo.tepDinhKem( dto.getTepDinhKem() );
        hoSo.ngayXoa( dto.getNgayXoa() );

        return hoSo.build();
    }

    @Override
    public List<HoSoDTO> toListDto(List<HoSo> list) {
        if ( list == null ) {
            return null;
        }

        List<HoSoDTO> list1 = new ArrayList<HoSoDTO>( list.size() );
        for ( HoSo hoSo : list ) {
            list1.add( toDTO( hoSo ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(HoSo entity, HoSoDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdHoSo() != null ) {
            entity.setIdHoSo( dto.getIdHoSo() );
        }
        if ( dto.getIdVeSi() != null ) {
            entity.setIdVeSi( dto.getIdVeSi() );
        }
        if ( dto.getLoaiHoSo() != null ) {
            entity.setLoaiHoSo( dto.getLoaiHoSo() );
        }
        if ( dto.getTepDinhKem() != null ) {
            entity.setTepDinhKem( dto.getTepDinhKem() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
