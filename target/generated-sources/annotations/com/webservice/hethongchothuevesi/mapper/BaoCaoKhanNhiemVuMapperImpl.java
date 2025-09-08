package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.BaoCaoKhanNhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.BaoCaoKhanNhiemVu;
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
public class BaoCaoKhanNhiemVuMapperImpl implements BaoCaoKhanNhiemVuMapper {

    @Override
    public BaoCaoKhanNhiemVuDTO toDTO(BaoCaoKhanNhiemVu entity) {
        if ( entity == null ) {
            return null;
        }

        BaoCaoKhanNhiemVuDTO.BaoCaoKhanNhiemVuDTOBuilder baoCaoKhanNhiemVuDTO = BaoCaoKhanNhiemVuDTO.builder();

        baoCaoKhanNhiemVuDTO.idBaoCaoKhan( entity.getIdBaoCaoKhan() );
        baoCaoKhanNhiemVuDTO.idNhiemVu( entity.getIdNhiemVu() );
        baoCaoKhanNhiemVuDTO.idNhanVien( entity.getIdNhanVien() );
        baoCaoKhanNhiemVuDTO.noiDung( entity.getNoiDung() );
        baoCaoKhanNhiemVuDTO.mucDoKhanCap( entity.getMucDoKhanCap() );
        baoCaoKhanNhiemVuDTO.trangThai( entity.getTrangThai() );
        baoCaoKhanNhiemVuDTO.ngayXoa( entity.getNgayXoa() );

        return baoCaoKhanNhiemVuDTO.build();
    }

    @Override
    public BaoCaoKhanNhiemVu toEntity(BaoCaoKhanNhiemVuDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BaoCaoKhanNhiemVu.BaoCaoKhanNhiemVuBuilder baoCaoKhanNhiemVu = BaoCaoKhanNhiemVu.builder();

        baoCaoKhanNhiemVu.idBaoCaoKhan( dto.getIdBaoCaoKhan() );
        baoCaoKhanNhiemVu.idNhiemVu( dto.getIdNhiemVu() );
        baoCaoKhanNhiemVu.idNhanVien( dto.getIdNhanVien() );
        baoCaoKhanNhiemVu.noiDung( dto.getNoiDung() );
        baoCaoKhanNhiemVu.mucDoKhanCap( dto.getMucDoKhanCap() );
        baoCaoKhanNhiemVu.trangThai( dto.getTrangThai() );
        baoCaoKhanNhiemVu.ngayXoa( dto.getNgayXoa() );

        return baoCaoKhanNhiemVu.build();
    }

    @Override
    public List<BaoCaoKhanNhiemVuDTO> toListDto(List<BaoCaoKhanNhiemVu> list) {
        if ( list == null ) {
            return null;
        }

        List<BaoCaoKhanNhiemVuDTO> list1 = new ArrayList<BaoCaoKhanNhiemVuDTO>( list.size() );
        for ( BaoCaoKhanNhiemVu baoCaoKhanNhiemVu : list ) {
            list1.add( toDTO( baoCaoKhanNhiemVu ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(BaoCaoKhanNhiemVu entity, BaoCaoKhanNhiemVuDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdBaoCaoKhan() != null ) {
            entity.setIdBaoCaoKhan( dto.getIdBaoCaoKhan() );
        }
        if ( dto.getIdNhiemVu() != null ) {
            entity.setIdNhiemVu( dto.getIdNhiemVu() );
        }
        if ( dto.getIdNhanVien() != null ) {
            entity.setIdNhanVien( dto.getIdNhanVien() );
        }
        if ( dto.getNoiDung() != null ) {
            entity.setNoiDung( dto.getNoiDung() );
        }
        if ( dto.getMucDoKhanCap() != null ) {
            entity.setMucDoKhanCap( dto.getMucDoKhanCap() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
