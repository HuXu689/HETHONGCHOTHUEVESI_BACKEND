package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucDichVuDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucDichVu;
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
public class DanhMucDichVuMapperImpl implements DanhMucDichVuMapper {

    @Override
    public DanhMucDichVuDTO toDTO(DanhMucDichVu entity) {
        if ( entity == null ) {
            return null;
        }

        DanhMucDichVuDTO.DanhMucDichVuDTOBuilder danhMucDichVuDTO = DanhMucDichVuDTO.builder();

        danhMucDichVuDTO.idDanhMucDichVu( entity.getIdDanhMucDichVu() );
        danhMucDichVuDTO.tenDichVu( entity.getTenDichVu() );
        danhMucDichVuDTO.moTa( entity.getMoTa() );
        danhMucDichVuDTO.giaDuKien( entity.getGiaDuKien() );
        danhMucDichVuDTO.ngayXoa( entity.getNgayXoa() );

        return danhMucDichVuDTO.build();
    }

    @Override
    public DanhMucDichVu toEntity(DanhMucDichVuDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DanhMucDichVu.DanhMucDichVuBuilder danhMucDichVu = DanhMucDichVu.builder();

        danhMucDichVu.idDanhMucDichVu( dto.getIdDanhMucDichVu() );
        danhMucDichVu.tenDichVu( dto.getTenDichVu() );
        danhMucDichVu.moTa( dto.getMoTa() );
        danhMucDichVu.giaDuKien( dto.getGiaDuKien() );
        danhMucDichVu.ngayXoa( dto.getNgayXoa() );

        return danhMucDichVu.build();
    }

    @Override
    public List<DanhMucDichVuDTO> toListDto(List<DanhMucDichVu> list) {
        if ( list == null ) {
            return null;
        }

        List<DanhMucDichVuDTO> list1 = new ArrayList<DanhMucDichVuDTO>( list.size() );
        for ( DanhMucDichVu danhMucDichVu : list ) {
            list1.add( toDTO( danhMucDichVu ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(DanhMucDichVu entity, DanhMucDichVuDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdDanhMucDichVu() != null ) {
            entity.setIdDanhMucDichVu( dto.getIdDanhMucDichVu() );
        }
        if ( dto.getTenDichVu() != null ) {
            entity.setTenDichVu( dto.getTenDichVu() );
        }
        if ( dto.getMoTa() != null ) {
            entity.setMoTa( dto.getMoTa() );
        }
        if ( dto.getGiaDuKien() != null ) {
            entity.setGiaDuKien( dto.getGiaDuKien() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
