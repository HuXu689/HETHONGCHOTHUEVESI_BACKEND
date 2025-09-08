package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKyNangDTO;
import com.webservice.hethongchothuevesi.entity.VeSiKyNang;
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
public class VeSiKyNangMapperImpl implements VeSiKyNangMapper {

    @Override
    public VeSiKyNangDTO toDTO(VeSiKyNang entity) {
        if ( entity == null ) {
            return null;
        }

        VeSiKyNangDTO.VeSiKyNangDTOBuilder veSiKyNangDTO = VeSiKyNangDTO.builder();

        veSiKyNangDTO.idVeSiKyNang( entity.getIdVeSiKyNang() );
        veSiKyNangDTO.idDanhMucKyNang( entity.getIdDanhMucKyNang() );
        veSiKyNangDTO.idVeSi( entity.getIdVeSi() );
        veSiKyNangDTO.capBac( entity.getCapBac() );
        veSiKyNangDTO.danhGia( entity.getDanhGia() );
        veSiKyNangDTO.ngayXoa( entity.getNgayXoa() );

        return veSiKyNangDTO.build();
    }

    @Override
    public VeSiKyNang toEntity(VeSiKyNangDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VeSiKyNang.VeSiKyNangBuilder veSiKyNang = VeSiKyNang.builder();

        veSiKyNang.idVeSiKyNang( dto.getIdVeSiKyNang() );
        veSiKyNang.idDanhMucKyNang( dto.getIdDanhMucKyNang() );
        veSiKyNang.idVeSi( dto.getIdVeSi() );
        veSiKyNang.capBac( dto.getCapBac() );
        veSiKyNang.danhGia( dto.getDanhGia() );
        veSiKyNang.ngayXoa( dto.getNgayXoa() );

        return veSiKyNang.build();
    }

    @Override
    public List<VeSiKyNangDTO> toListDto(List<VeSiKyNang> list) {
        if ( list == null ) {
            return null;
        }

        List<VeSiKyNangDTO> list1 = new ArrayList<VeSiKyNangDTO>( list.size() );
        for ( VeSiKyNang veSiKyNang : list ) {
            list1.add( toDTO( veSiKyNang ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(VeSiKyNang entity, VeSiKyNangDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdVeSiKyNang() != null ) {
            entity.setIdVeSiKyNang( dto.getIdVeSiKyNang() );
        }
        if ( dto.getIdDanhMucKyNang() != null ) {
            entity.setIdDanhMucKyNang( dto.getIdDanhMucKyNang() );
        }
        if ( dto.getIdVeSi() != null ) {
            entity.setIdVeSi( dto.getIdVeSi() );
        }
        if ( dto.getCapBac() != null ) {
            entity.setCapBac( dto.getCapBac() );
        }
        if ( dto.getDanhGia() != null ) {
            entity.setDanhGia( dto.getDanhGia() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
