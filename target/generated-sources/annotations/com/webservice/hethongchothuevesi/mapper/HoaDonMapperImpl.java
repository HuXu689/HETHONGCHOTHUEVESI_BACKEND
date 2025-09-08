package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.HoaDonDTO;
import com.webservice.hethongchothuevesi.entity.HoaDon;
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
public class HoaDonMapperImpl implements HoaDonMapper {

    @Override
    public HoaDonDTO toDTO(HoaDon entity) {
        if ( entity == null ) {
            return null;
        }

        HoaDonDTO.HoaDonDTOBuilder hoaDonDTO = HoaDonDTO.builder();

        hoaDonDTO.idHoaDon( entity.getIdHoaDon() );
        hoaDonDTO.idHopDong( entity.getIdHopDong() );
        hoaDonDTO.ngayLap( entity.getNgayLap() );
        hoaDonDTO.tongTien( entity.getTongTien() );
        hoaDonDTO.phuongThucThanhToan( entity.getPhuongThucThanhToan() );
        hoaDonDTO.trangThai( entity.getTrangThai() );
        hoaDonDTO.ngayXoa( entity.getNgayXoa() );

        return hoaDonDTO.build();
    }

    @Override
    public HoaDon toEntity(HoaDonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HoaDon.HoaDonBuilder hoaDon = HoaDon.builder();

        hoaDon.idHoaDon( dto.getIdHoaDon() );
        hoaDon.idHopDong( dto.getIdHopDong() );
        hoaDon.ngayLap( dto.getNgayLap() );
        hoaDon.tongTien( dto.getTongTien() );
        hoaDon.phuongThucThanhToan( dto.getPhuongThucThanhToan() );
        hoaDon.trangThai( dto.getTrangThai() );
        hoaDon.ngayXoa( dto.getNgayXoa() );

        return hoaDon.build();
    }

    @Override
    public List<HoaDonDTO> toListDto(List<HoaDon> list) {
        if ( list == null ) {
            return null;
        }

        List<HoaDonDTO> list1 = new ArrayList<HoaDonDTO>( list.size() );
        for ( HoaDon hoaDon : list ) {
            list1.add( toDTO( hoaDon ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(HoaDon entity, HoaDonDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdHoaDon() != null ) {
            entity.setIdHoaDon( dto.getIdHoaDon() );
        }
        if ( dto.getIdHopDong() != null ) {
            entity.setIdHopDong( dto.getIdHopDong() );
        }
        if ( dto.getNgayLap() != null ) {
            entity.setNgayLap( dto.getNgayLap() );
        }
        if ( dto.getTongTien() != null ) {
            entity.setTongTien( dto.getTongTien() );
        }
        if ( dto.getPhuongThucThanhToan() != null ) {
            entity.setPhuongThucThanhToan( dto.getPhuongThucThanhToan() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
