package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.request.NguoiDungCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.NguoiDungResponse;
import com.webservice.hethongchothuevesi.entity.NguoiDung;
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
public class NguoiDungMapperImpl implements NguoiDungMapper {

    @Override
    public NguoiDungResponse toNguoiDungResponse(NguoiDung nguoiDung) {
        if ( nguoiDung == null ) {
            return null;
        }

        NguoiDungResponse.NguoiDungResponseBuilder nguoiDungResponse = NguoiDungResponse.builder();

        nguoiDungResponse.idNguoiDung( nguoiDung.getIdNguoiDung() );
        nguoiDungResponse.tenDangNhap( nguoiDung.getTenDangNhap() );
        nguoiDungResponse.idAnhDaiDien( nguoiDung.getIdAnhDaiDien() );
        nguoiDungResponse.anhDaiDien( nguoiDung.getAnhDaiDien() );
        nguoiDungResponse.gioiTinh( nguoiDung.getGioiTinh() );
        nguoiDungResponse.ngaySinh( nguoiDung.getNgaySinh() );
        nguoiDungResponse.email( nguoiDung.getEmail() );
        nguoiDungResponse.soDienThoai( nguoiDung.getSoDienThoai() );
        nguoiDungResponse.hoTen( nguoiDung.getHoTen() );
        nguoiDungResponse.soCccd( nguoiDung.getSoCccd() );
        nguoiDungResponse.diaChi( nguoiDung.getDiaChi() );
        nguoiDungResponse.trangThai( nguoiDung.getTrangThai() );

        return nguoiDungResponse.build();
    }

    @Override
    public List<NguoiDungResponse> toNguoiDungResponse(List<NguoiDung> list) {
        if ( list == null ) {
            return null;
        }

        List<NguoiDungResponse> list1 = new ArrayList<NguoiDungResponse>( list.size() );
        for ( NguoiDung nguoiDung : list ) {
            list1.add( toNguoiDungResponse( nguoiDung ) );
        }

        return list1;
    }

    @Override
    public NguoiDung toNguoiDung(NguoiDungCreationRequest nguoiDung) {
        if ( nguoiDung == null ) {
            return null;
        }

        NguoiDung.NguoiDungBuilder nguoiDung1 = NguoiDung.builder();

        nguoiDung1.tenDangNhap( nguoiDung.getTenDangNhap() );
        nguoiDung1.matKhau( nguoiDung.getMatKhau() );
        nguoiDung1.idAnhDaiDien( nguoiDung.getIdAnhDaiDien() );
        nguoiDung1.anhDaiDien( nguoiDung.getAnhDaiDien() );
        nguoiDung1.hoTen( nguoiDung.getHoTen() );
        nguoiDung1.gioiTinh( nguoiDung.getGioiTinh() );
        nguoiDung1.ngaySinh( nguoiDung.getNgaySinh() );
        nguoiDung1.email( nguoiDung.getEmail() );
        nguoiDung1.soDienThoai( nguoiDung.getSoDienThoai() );
        nguoiDung1.soCccd( nguoiDung.getSoCccd() );
        nguoiDung1.diaChi( nguoiDung.getDiaChi() );

        return nguoiDung1.build();
    }

    @Override
    public void updateNguoiDung(NguoiDung nguoiDung, NguoiDungUpdateRequest nguoiDungUpdateRequest) {
        if ( nguoiDungUpdateRequest == null ) {
            return;
        }

        if ( nguoiDungUpdateRequest.getIdAnhDaiDien() != null ) {
            nguoiDung.setIdAnhDaiDien( nguoiDungUpdateRequest.getIdAnhDaiDien() );
        }
        if ( nguoiDungUpdateRequest.getAnhDaiDien() != null ) {
            nguoiDung.setAnhDaiDien( nguoiDungUpdateRequest.getAnhDaiDien() );
        }
        if ( nguoiDungUpdateRequest.getHoTen() != null ) {
            nguoiDung.setHoTen( nguoiDungUpdateRequest.getHoTen() );
        }
        if ( nguoiDungUpdateRequest.getGioiTinh() != null ) {
            nguoiDung.setGioiTinh( nguoiDungUpdateRequest.getGioiTinh() );
        }
        if ( nguoiDungUpdateRequest.getNgaySinh() != null ) {
            nguoiDung.setNgaySinh( nguoiDungUpdateRequest.getNgaySinh() );
        }
        if ( nguoiDungUpdateRequest.getEmail() != null ) {
            nguoiDung.setEmail( nguoiDungUpdateRequest.getEmail() );
        }
        if ( nguoiDungUpdateRequest.getSoDienThoai() != null ) {
            nguoiDung.setSoDienThoai( nguoiDungUpdateRequest.getSoDienThoai() );
        }
        if ( nguoiDungUpdateRequest.getSoCccd() != null ) {
            nguoiDung.setSoCccd( nguoiDungUpdateRequest.getSoCccd() );
        }
        if ( nguoiDungUpdateRequest.getDiaChi() != null ) {
            nguoiDung.setDiaChi( nguoiDungUpdateRequest.getDiaChi() );
        }
    }
}
