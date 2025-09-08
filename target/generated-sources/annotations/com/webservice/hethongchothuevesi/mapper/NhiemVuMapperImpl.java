package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
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
public class NhiemVuMapperImpl implements NhiemVuMapper {

    @Override
    public NhiemVuDTO toDTO(NhiemVu entity) {
        if ( entity == null ) {
            return null;
        }

        NhiemVuDTO.NhiemVuDTOBuilder nhiemVuDTO = NhiemVuDTO.builder();

        nhiemVuDTO.idNhiemVu( entity.getIdNhiemVu() );
        nhiemVuDTO.idHopDong( entity.getIdHopDong() );
        nhiemVuDTO.idVeSi( entity.getIdVeSi() );
        nhiemVuDTO.ngayBatDau( entity.getNgayBatDau() );
        nhiemVuDTO.ngayKetThuc( entity.getNgayKetThuc() );
        nhiemVuDTO.capBac( entity.getCapBac() );
        nhiemVuDTO.noiDung( entity.getNoiDung() );
        nhiemVuDTO.danhGiaKyNangChuyenMon( entity.getDanhGiaKyNangChuyenMon() );
        nhiemVuDTO.danhGiaXuLyTinhHuong( entity.getDanhGiaXuLyTinhHuong() );
        nhiemVuDTO.danhGiaThaiDoDaoDuc( entity.getDanhGiaThaiDoDaoDuc() );
        nhiemVuDTO.danhGiaGiaoTiep( entity.getDanhGiaGiaoTiep() );
        nhiemVuDTO.danhGiaNgoaiHinh( entity.getDanhGiaNgoaiHinh() );
        nhiemVuDTO.thongTinDanhGia( entity.getThongTinDanhGia() );
        nhiemVuDTO.trangThai( entity.getTrangThai() );
        nhiemVuDTO.ngayXoa( entity.getNgayXoa() );

        return nhiemVuDTO.build();
    }

    @Override
    public NhiemVu toEntity(NhiemVuDTO dto) {
        if ( dto == null ) {
            return null;
        }

        NhiemVu.NhiemVuBuilder nhiemVu = NhiemVu.builder();

        nhiemVu.idNhiemVu( dto.getIdNhiemVu() );
        nhiemVu.idHopDong( dto.getIdHopDong() );
        nhiemVu.idVeSi( dto.getIdVeSi() );
        nhiemVu.ngayBatDau( dto.getNgayBatDau() );
        nhiemVu.ngayKetThuc( dto.getNgayKetThuc() );
        nhiemVu.capBac( dto.getCapBac() );
        nhiemVu.noiDung( dto.getNoiDung() );
        nhiemVu.danhGiaKyNangChuyenMon( dto.getDanhGiaKyNangChuyenMon() );
        nhiemVu.danhGiaXuLyTinhHuong( dto.getDanhGiaXuLyTinhHuong() );
        nhiemVu.danhGiaThaiDoDaoDuc( dto.getDanhGiaThaiDoDaoDuc() );
        nhiemVu.danhGiaGiaoTiep( dto.getDanhGiaGiaoTiep() );
        nhiemVu.danhGiaNgoaiHinh( dto.getDanhGiaNgoaiHinh() );
        nhiemVu.thongTinDanhGia( dto.getThongTinDanhGia() );
        nhiemVu.trangThai( dto.getTrangThai() );
        nhiemVu.ngayXoa( dto.getNgayXoa() );

        return nhiemVu.build();
    }

    @Override
    public List<NhiemVuDTO> toListDto(List<NhiemVu> list) {
        if ( list == null ) {
            return null;
        }

        List<NhiemVuDTO> list1 = new ArrayList<NhiemVuDTO>( list.size() );
        for ( NhiemVu nhiemVu : list ) {
            list1.add( toDTO( nhiemVu ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(NhiemVu entity, NhiemVuDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdNhiemVu() != null ) {
            entity.setIdNhiemVu( dto.getIdNhiemVu() );
        }
        if ( dto.getIdHopDong() != null ) {
            entity.setIdHopDong( dto.getIdHopDong() );
        }
        if ( dto.getIdVeSi() != null ) {
            entity.setIdVeSi( dto.getIdVeSi() );
        }
        if ( dto.getNgayBatDau() != null ) {
            entity.setNgayBatDau( dto.getNgayBatDau() );
        }
        if ( dto.getNgayKetThuc() != null ) {
            entity.setNgayKetThuc( dto.getNgayKetThuc() );
        }
        if ( dto.getCapBac() != null ) {
            entity.setCapBac( dto.getCapBac() );
        }
        if ( dto.getNoiDung() != null ) {
            entity.setNoiDung( dto.getNoiDung() );
        }
        if ( dto.getDanhGiaKyNangChuyenMon() != null ) {
            entity.setDanhGiaKyNangChuyenMon( dto.getDanhGiaKyNangChuyenMon() );
        }
        if ( dto.getDanhGiaXuLyTinhHuong() != null ) {
            entity.setDanhGiaXuLyTinhHuong( dto.getDanhGiaXuLyTinhHuong() );
        }
        if ( dto.getDanhGiaThaiDoDaoDuc() != null ) {
            entity.setDanhGiaThaiDoDaoDuc( dto.getDanhGiaThaiDoDaoDuc() );
        }
        if ( dto.getDanhGiaGiaoTiep() != null ) {
            entity.setDanhGiaGiaoTiep( dto.getDanhGiaGiaoTiep() );
        }
        if ( dto.getDanhGiaNgoaiHinh() != null ) {
            entity.setDanhGiaNgoaiHinh( dto.getDanhGiaNgoaiHinh() );
        }
        if ( dto.getThongTinDanhGia() != null ) {
            entity.setThongTinDanhGia( dto.getThongTinDanhGia() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }

    @Override
    public void updateEntityFromDto(NhiemVuDTO dto, NhiemVu entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdNhiemVu() != null ) {
            entity.setIdNhiemVu( dto.getIdNhiemVu() );
        }
        if ( dto.getIdHopDong() != null ) {
            entity.setIdHopDong( dto.getIdHopDong() );
        }
        if ( dto.getIdVeSi() != null ) {
            entity.setIdVeSi( dto.getIdVeSi() );
        }
        if ( dto.getNgayBatDau() != null ) {
            entity.setNgayBatDau( dto.getNgayBatDau() );
        }
        if ( dto.getNgayKetThuc() != null ) {
            entity.setNgayKetThuc( dto.getNgayKetThuc() );
        }
        if ( dto.getCapBac() != null ) {
            entity.setCapBac( dto.getCapBac() );
        }
        if ( dto.getNoiDung() != null ) {
            entity.setNoiDung( dto.getNoiDung() );
        }
        if ( dto.getDanhGiaKyNangChuyenMon() != null ) {
            entity.setDanhGiaKyNangChuyenMon( dto.getDanhGiaKyNangChuyenMon() );
        }
        if ( dto.getDanhGiaXuLyTinhHuong() != null ) {
            entity.setDanhGiaXuLyTinhHuong( dto.getDanhGiaXuLyTinhHuong() );
        }
        if ( dto.getDanhGiaThaiDoDaoDuc() != null ) {
            entity.setDanhGiaThaiDoDaoDuc( dto.getDanhGiaThaiDoDaoDuc() );
        }
        if ( dto.getDanhGiaGiaoTiep() != null ) {
            entity.setDanhGiaGiaoTiep( dto.getDanhGiaGiaoTiep() );
        }
        if ( dto.getDanhGiaNgoaiHinh() != null ) {
            entity.setDanhGiaNgoaiHinh( dto.getDanhGiaNgoaiHinh() );
        }
        if ( dto.getThongTinDanhGia() != null ) {
            entity.setThongTinDanhGia( dto.getThongTinDanhGia() );
        }
        if ( dto.getTrangThai() != null ) {
            entity.setTrangThai( dto.getTrangThai() );
        }
        if ( dto.getNgayXoa() != null ) {
            entity.setNgayXoa( dto.getNgayXoa() );
        }
    }
}
