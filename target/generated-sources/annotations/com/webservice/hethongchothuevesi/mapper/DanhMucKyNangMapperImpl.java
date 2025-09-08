package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucKyNangDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucKyNang;
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
public class DanhMucKyNangMapperImpl implements DanhMucKyNangMapper {

    @Override
    public DanhMucKyNangDTO toDTO(DanhMucKyNang entity) {
        if ( entity == null ) {
            return null;
        }

        DanhMucKyNangDTO.DanhMucKyNangDTOBuilder danhMucKyNangDTO = DanhMucKyNangDTO.builder();

        danhMucKyNangDTO.idDanhMucKyNang( entity.getIdDanhMucKyNang() );
        danhMucKyNangDTO.tenKyNang( entity.getTenKyNang() );
        danhMucKyNangDTO.moTa( entity.getMoTa() );
        danhMucKyNangDTO.ngayXoa( entity.getNgayXoa() );

        return danhMucKyNangDTO.build();
    }

    @Override
    public DanhMucKyNang toEntity(DanhMucKyNangDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DanhMucKyNang.DanhMucKyNangBuilder danhMucKyNang = DanhMucKyNang.builder();

        danhMucKyNang.idDanhMucKyNang( dto.getIdDanhMucKyNang() );
        danhMucKyNang.tenKyNang( dto.getTenKyNang() );
        danhMucKyNang.moTa( dto.getMoTa() );
        danhMucKyNang.ngayXoa( dto.getNgayXoa() );

        return danhMucKyNang.build();
    }

    @Override
    public List<DanhMucKyNangDTO> toListDto(List<DanhMucKyNang> list) {
        if ( list == null ) {
            return null;
        }

        List<DanhMucKyNangDTO> list1 = new ArrayList<DanhMucKyNangDTO>( list.size() );
        for ( DanhMucKyNang danhMucKyNang : list ) {
            list1.add( toDTO( danhMucKyNang ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(DanhMucKyNang entity, DanhMucKyNangDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdDanhMucKyNang() != null ) {
            entity.setIdDanhMucKyNang( dto.getIdDanhMucKyNang() );
        }
        if ( dto.getTenKyNang() != null ) {
            entity.setTenKyNang( dto.getTenKyNang() );
        }
        if ( dto.getMoTa() != null ) {
            entity.setMoTa( dto.getMoTa() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
