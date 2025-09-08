package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.ThongBao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T19:01:13+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ThongBaoMapperImpl implements ThongBaoMapper {

    @Override
    public ThongBaoDTO toDTO(ThongBao entity) {
        if ( entity == null ) {
            return null;
        }

        ThongBaoDTO.ThongBaoDTOBuilder thongBaoDTO = ThongBaoDTO.builder();

        thongBaoDTO.idThongBao( entity.getIdThongBao() );
        thongBaoDTO.idNhanVien( entity.getIdNhanVien() );
        thongBaoDTO.idDanhMucThongBao( entity.getIdDanhMucThongBao() );
        thongBaoDTO.tieuDe( entity.getTieuDe() );
        thongBaoDTO.noiDung( entity.getNoiDung() );
        thongBaoDTO.ngayXoa( entity.getNgayXoa() );

        return thongBaoDTO.build();
    }

    @Override
    public ThongBao toEntity(ThongBaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ThongBao.ThongBaoBuilder thongBao = ThongBao.builder();

        thongBao.idThongBao( dto.getIdThongBao() );
        thongBao.idNhanVien( dto.getIdNhanVien() );
        thongBao.idDanhMucThongBao( dto.getIdDanhMucThongBao() );
        thongBao.tieuDe( dto.getTieuDe() );
        thongBao.noiDung( dto.getNoiDung() );
        thongBao.ngayXoa( dto.getNgayXoa() );

        return thongBao.build();
    }

    @Override
    public List<ThongBaoDTO> toListDto(List<ThongBao> list) {
        if ( list == null ) {
            return null;
        }

        List<ThongBaoDTO> list1 = new ArrayList<ThongBaoDTO>( list.size() );
        for ( ThongBao thongBao : list ) {
            list1.add( toDTO( thongBao ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(ThongBao entity, ThongBaoDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdThongBao() != null ) {
            entity.setIdThongBao( dto.getIdThongBao() );
        }
        if ( dto.getIdNhanVien() != null ) {
            entity.setIdNhanVien( dto.getIdNhanVien() );
        }
        if ( dto.getIdDanhMucThongBao() != null ) {
            entity.setIdDanhMucThongBao( dto.getIdDanhMucThongBao() );
        }
        if ( dto.getTieuDe() != null ) {
            entity.setTieuDe( dto.getTieuDe() );
        }
        if ( dto.getNoiDung() != null ) {
            entity.setNoiDung( dto.getNoiDung() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
