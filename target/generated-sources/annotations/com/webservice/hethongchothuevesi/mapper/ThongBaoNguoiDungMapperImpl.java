package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoNguoiDungDTO;
import com.webservice.hethongchothuevesi.entity.ThongBaoNguoiDung;
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
public class ThongBaoNguoiDungMapperImpl implements ThongBaoNguoiDungMapper {

    @Override
    public ThongBaoNguoiDungDTO toDTO(ThongBaoNguoiDung entity) {
        if ( entity == null ) {
            return null;
        }

        ThongBaoNguoiDungDTO.ThongBaoNguoiDungDTOBuilder thongBaoNguoiDungDTO = ThongBaoNguoiDungDTO.builder();

        thongBaoNguoiDungDTO.idThongBaoNguoiDung( entity.getIdThongBaoNguoiDung() );
        thongBaoNguoiDungDTO.idThongBao( entity.getIdThongBao() );
        thongBaoNguoiDungDTO.idNguoiDung( entity.getIdNguoiDung() );
        thongBaoNguoiDungDTO.thoiGianDoc( entity.getThoiGianDoc() );
        thongBaoNguoiDungDTO.ngayXoa( entity.getNgayXoa() );

        return thongBaoNguoiDungDTO.build();
    }

    @Override
    public ThongBaoNguoiDung toEntity(ThongBaoNguoiDungDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ThongBaoNguoiDung.ThongBaoNguoiDungBuilder thongBaoNguoiDung = ThongBaoNguoiDung.builder();

        thongBaoNguoiDung.idThongBaoNguoiDung( dto.getIdThongBaoNguoiDung() );
        thongBaoNguoiDung.idThongBao( dto.getIdThongBao() );
        thongBaoNguoiDung.idNguoiDung( dto.getIdNguoiDung() );
        thongBaoNguoiDung.thoiGianDoc( dto.getThoiGianDoc() );
        thongBaoNguoiDung.ngayXoa( dto.getNgayXoa() );

        return thongBaoNguoiDung.build();
    }

    @Override
    public List<ThongBaoNguoiDungDTO> toListDto(List<ThongBaoNguoiDung> list) {
        if ( list == null ) {
            return null;
        }

        List<ThongBaoNguoiDungDTO> list1 = new ArrayList<ThongBaoNguoiDungDTO>( list.size() );
        for ( ThongBaoNguoiDung thongBaoNguoiDung : list ) {
            list1.add( toDTO( thongBaoNguoiDung ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(ThongBaoNguoiDung entity, ThongBaoNguoiDungDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdThongBaoNguoiDung() != null ) {
            entity.setIdThongBaoNguoiDung( dto.getIdThongBaoNguoiDung() );
        }
        if ( dto.getIdThongBao() != null ) {
            entity.setIdThongBao( dto.getIdThongBao() );
        }
        if ( dto.getIdNguoiDung() != null ) {
            entity.setIdNguoiDung( dto.getIdNguoiDung() );
        }
        if ( dto.getThoiGianDoc() != null ) {
            entity.setThoiGianDoc( dto.getThoiGianDoc() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
