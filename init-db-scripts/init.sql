ALTER DATABASE HETHONGCHOTHUEVESI
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
-- Bảng VaiTro c1
CREATE TABLE VaiTro (
                        idVaiTro INT AUTO_INCREMENT,
                        tenVaiTro VARCHAR(255) NOT NULL, -- Tên vai trò (VD: "KhachHang", "VeSi", "NhanVien")
                        capBac VARCHAR(255), -- Cấp bậc trong vai trò (VD: "Admin", "Manager", "Employee")
                        moTa VARCHAR(255),
                        PRIMARY KEY (idVaiTro)
);

CREATE INDEX idx_vaitro_tenvaitro ON VaiTro (tenVaiTro);

-- Bảng NguoiDung c1
CREATE TABLE NguoiDung (
                           idNguoiDung INT AUTO_INCREMENT,
                           tenDangNhap VARCHAR(255) UNIQUE NOT NULL,
                           matKhau VARCHAR(255) NOT NULL,
                           anhDaiDien VARCHAR(255),
                           hoTen VARCHAR(255),
                           gioiTinh ENUM('Nam', 'Nữ', 'Khác') DEFAULT 'Khác',
                           ngaySinh DATE,
                           email VARCHAR(255) UNIQUE,
                           soDienThoai VARCHAR(14) UNIQUE,
                           soCCCD VARCHAR(20),
                           diaChi VARCHAR(255),
                           trangThai ENUM('Hoạt động', 'Khóa') DEFAULT 'Hoạt động',
                           ngayXoa DATETIME,
                           PRIMARY KEY (idNguoiDung)
);

CREATE INDEX idx_nguoidung_email ON NguoiDung (email);
CREATE INDEX idx_nguoidung_sodienthoai ON NguoiDung (soDienThoai);
CREATE INDEX idx_nguoidung_tendangnhap ON NguoiDung (tenDangNhap);
CREATE INDEX idx_nguoidung_socccd ON NguoiDung (soCCCD);

-- Bảng DanhMucKyNang c1
CREATE TABLE DanhMucKyNang (
                               idDanhMucKyNang INT AUTO_INCREMENT,
                               tenKyNang VARCHAR(255),
                               moTa VARCHAR(255),
                               ngayXoa DATETIME,
                               PRIMARY KEY (idDanhMucKyNang)
);

CREATE INDEX idx_danhmuckynang_ngayxoa ON DanhMucKyNang (ngayXoa);
CREATE INDEX idx_danhmuckynang_tenkyngang ON DanhMucKyNang (tenKyNang);

-- Bảng DanhMucDichVu c1
CREATE TABLE DanhMucDichVu (
                               idDanhMucDichVu INT AUTO_INCREMENT,
                               tenDichVu VARCHAR(255),
                               moTa VARCHAR(255),
                               giaDuKien DECIMAL(18,2),
                               ngayXoa DATETIME,
                               PRIMARY KEY (idDanhMucDichVu)
);

CREATE INDEX idx_danhmucdichvu_ngayxoa ON DanhMucDichVu (ngayXoa);
CREATE INDEX idx_danhmucdichvu_tendichvu ON DanhMucDichVu (tenDichVu);
CREATE INDEX idx_danhmucdichvu_giadukien ON DanhMucDichVu (giaDuKien);

-- Bảng DanhMucThongBao c1
CREATE TABLE DanhMucThongBao (
                                 idDanhMucThongBao INT AUTO_INCREMENT,
                                 tenLoaiThongBao VARCHAR(255),
                                 moTa VARCHAR(255),
                                 ngayXoa DATETIME,
                                 PRIMARY KEY (idDanhMucThongBao)
);

CREATE INDEX idx_danhmucthongbao_ngayxoa ON DanhMucThongBao (ngayXoa);
CREATE INDEX idx_danhmucthongbao_tenloai ON DanhMucThongBao (tenLoaiThongBao);

-- Bảng DanhMucKhoaDaoTao c1
CREATE TABLE DanhMucKhoaDaoTao (
                                   idDanhMucKhoaDaoTao INT AUTO_INCREMENT,
                                   tenKhoaDaoTao VARCHAR(255),
                                   moTa VARCHAR(255),
                                   ngayXoa DATETIME,
                                   PRIMARY KEY (idDanhMucKhoaDaoTao)
);

CREATE INDEX idx_danhmuckhoadaotao_ngayxoa ON DanhMucKhoaDaoTao (ngayXoa);

-- Bảng VeSi c2
CREATE TABLE VeSi (
                      idVeSi INT AUTO_INCREMENT,
                      idNguoiDung INT,
                      kinhNghiem INT,
                      thongTinDanhGiaChung VARCHAR(255),
                      ngayBatDauLam DATE,
                      capBac VARCHAR(255),
                      ngayLenCap DATE,
                      luong DECIMAL(18,2),
                      trangThai ENUM('Hoạt động', 'Tạm nghỉ', 'Đang khóa', 'Nghỉ việc') DEFAULT 'Hoạt động',
                      ngayXoa DATETIME,
                      PRIMARY KEY (idVeSi),
                      FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(idNguoiDung) ON DELETE CASCADE
);

CREATE INDEX idx_vesi_ngayxoa ON VeSi (ngayXoa);

-- Bảng NhanVien c2
CREATE TABLE NhanVien (
                          idNhanVien INT AUTO_INCREMENT,
                          idNguoiDung INT,
                          ngayBatDauLam DATE,
                          capBac VARCHAR(255),
                          ngayLenCap DATE,
                          luong DECIMAL(18,2),
                          trangThai ENUM('Hoạt động', 'Tạm nghỉ', 'Đang khóa', 'Nghỉ việc') DEFAULT 'Hoạt động',
                          ngayXoa DATETIME,
                          PRIMARY KEY (idNhanVien),
                          FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(idNguoiDung) ON DELETE CASCADE
);

CREATE INDEX idx_nhanvien_ngayxoa ON NhanVien (ngayXoa);

-- Bảng LichSuHoatDong c2
CREATE TABLE LichSuHoatDong (
                                idLichSuHoatDong INT AUTO_INCREMENT,
                                idNguoiDung INT,
                                idDoiTuong INT,
                                loaiDoiTuong VARCHAR(255), -- Tên bảng trên csdl
                                thoiGianThucHien DATETIME,
                                hoatDong VARCHAR(255),
                                thongTinHoatDong VARCHAR(255),
                                PRIMARY KEY (idLichSuHoatDong),
                                FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(idNguoiDung) ON DELETE CASCADE
);

-- Bảng NguoiDungVaiTro c2
CREATE TABLE NguoiDungVaiTro (
                                 idNguoiDungVaiTro INT AUTO_INCREMENT,
                                 idNguoiDung INT NOT NULL,
                                 idVaiTro INT NOT NULL,
                                 PRIMARY KEY (idNguoiDungVaiTro),
                                 FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(idNguoiDung) ON DELETE CASCADE,
                                 FOREIGN KEY (idVaiTro) REFERENCES VaiTro(idVaiTro) ON DELETE CASCADE
);

CREATE INDEX idx_nguoidung_vaitro ON NguoiDungVaiTro (idNguoiDung, idVaiTro);

-- Bảng YeuCauDichVu c2
CREATE TABLE YeuCauDichVu (
                              idYeuCauDichVu INT AUTO_INCREMENT,
                              idNguoiDung INT,
                              idDanhMucDichVu INT,
                              hoTenKhachHang VARCHAR(255),
                              soDienThoai VARCHAR(14),
                              anh VARCHAR(255),
                              soCCCD VARCHAR(20),
                              diaDiem VARCHAR(255),
                              soLuongVeSi INT,
                              ngayBatDau DATE,
                              ngayKetThuc DATE,
                              giaTienDuKien DECIMAL(18,2),
                              ghiChu VARCHAR(255),
                              noiDungTraLoi VARCHAR(255),
                              trangThai ENUM('Chưa xác nhận', 'Đang xử lý', 'Hoàn thành', 'Hủy bỏ') DEFAULT 'Chưa xác nhận',
                              ngayXoa DATETIME,
                              PRIMARY KEY (idYeuCauDichVu),
                              FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(idNguoiDung) ON DELETE CASCADE,
                              FOREIGN KEY (idDanhMucDichVu) REFERENCES DanhMucDichVu(idDanhMucDichVu) ON DELETE CASCADE
);

CREATE INDEX idx_yeucaudichvu_nguoidung ON YeuCauDichVu (idNguoiDung);
CREATE INDEX idx_yeucaudichvu_dichvu ON YeuCauDichVu (idDanhMucDichVu);
CREATE INDEX idx_yeucaudichvu_ngayxoa ON YeuCauDichVu (ngayXoa);

-- Bảng KhoaDaoTao c2
CREATE TABLE KhoaDaoTao (
                            idKhoaDaoTao INT AUTO_INCREMENT,
                            idDanhMucKhoaDaoTao INT,
                            tenKhoaDaoTao VARCHAR(255),
                            diaDiem VARCHAR(255),
                            ngayBatDau DATE,
                            ngayKetThuc DATE,
                            moTa VARCHAR(255),
                            trangThai ENUM('Chưa bắt đầu', 'Đang diễn ra', 'Kết thúc', 'Hủy bỏ') DEFAULT 'Chưa bắt đầu',
                            ngayXoa DATETIME,
                            PRIMARY KEY (idKhoaDaoTao),
                            FOREIGN KEY (idDanhMucKhoaDaoTao) REFERENCES DanhMucKhoaDaoTao(idDanhMucKhoaDaoTao) ON DELETE CASCADE
);

CREATE INDEX idx_khoadaotao_danhmuckhoadaotao ON KhoaDaoTao (idDanhMucKhoaDaoTao);
CREATE INDEX idx_khoadaotao_ngayxoa ON KhoaDaoTao (ngayXoa);

-- Bảng HoSo c3
CREATE TABLE HoSo (
                      idHoSo INT AUTO_INCREMENT,
                      idVeSi INT,
                      loaiHoSo VARCHAR(255),
                      tepDinhKem VARCHAR(255),
                      ngayXoa DATETIME,
                      PRIMARY KEY (idHoSo),
                      FOREIGN KEY (idVeSi) REFERENCES VeSi(idVeSi) ON DELETE CASCADE
);

CREATE INDEX idx_hoso_vesi ON HoSo (idVeSi);
CREATE INDEX idx_hoso_ngayxoa ON HoSo (ngayXoa);

-- Bảng VeSiKyNang c3
CREATE TABLE VeSiKyNang (
                            idVeSiKyNang INT AUTO_INCREMENT,
                            idDanhMucKyNang INT,
                            idVeSi INT,
                            capBac VARCHAR(255),
                            danhGia VARCHAR(255),
                            ngayXoa DATETIME,
                            PRIMARY KEY (idVeSiKyNang),
                            FOREIGN KEY (idDanhMucKyNang) REFERENCES DanhMucKyNang(idDanhMucKyNang) ON DELETE CASCADE,
                            FOREIGN KEY (idVeSi) REFERENCES VeSi(idVeSi) ON DELETE CASCADE
);

CREATE INDEX idx_vesikynang_danhmuckynang ON VeSiKyNang (idDanhMucKyNang);
CREATE INDEX idx_vesikynang_vesi ON VeSiKyNang (idVeSi);
CREATE INDEX idx_vesikynang_ngayxoa ON VeSiKyNang (ngayXoa);

-- Bảng HopDong c3
CREATE TABLE HopDong (
                         idHopDong INT AUTO_INCREMENT,
                         idYeuCauDichVu INT,
                         hoTenKhachHang VARCHAR(255),
                         soDienThoai VARCHAR(14),
                         anh VARCHAR(255),
                         soCCCD VARCHAR(20),
                         diaDiem VARCHAR(255),
                         soLuongVeSi INT,
                         thoiGianBatDau DATETIME,
                         thoiGianKetThuc DATETIME,
                         tongChiPhi DECIMAL(18,2),
                         ghiChu VARCHAR(255),
                         soSaoDanhGia INT,
                         thongTinDanhGia VARCHAR(255),
                         trangThai ENUM('Chưa hoàn thành', 'Đang thực hiện', 'Hoàn thành', 'Đã hủy') NOT NULL,
                         ngayXoa DATETIME,
                         PRIMARY KEY (idHopDong),
                         FOREIGN KEY (idYeuCauDichVu) REFERENCES YeuCauDichVu(idYeuCauDichVu) ON DELETE CASCADE
);

CREATE INDEX idx_hopdong_yeucaudichvu ON HopDong (idYeuCauDichVu);
CREATE INDEX idx_hopdong_ngayxoa ON HopDong (ngayXoa);

-- Bảng ThongBao c3
CREATE TABLE ThongBao (
                          idThongBao INT AUTO_INCREMENT,
                          idNhanVien INT,
                          idDanhMucThongBao INT,
                          tieuDe VARCHAR(255),
                          noiDung VARCHAR(255),
                          ngayXoa DATETIME,
                          PRIMARY KEY (idThongBao),
                          FOREIGN KEY (idNhanVien) REFERENCES NhanVien(idNhanVien) ON DELETE CASCADE,
                          FOREIGN KEY (idDanhMucThongBao) REFERENCES DanhMucThongBao(idDanhMucThongBao) ON DELETE CASCADE
);

CREATE INDEX idx_thongbao_nhanvien ON ThongBao (idNhanVien);
CREATE INDEX idx_thongbao_danhmucthongbao ON ThongBao (idDanhMucThongBao);
CREATE INDEX idx_thongbao_ngayxoa ON ThongBao (ngayXoa);

-- Bảng VeSiKhoaDaoTao c3
CREATE TABLE VeSiKhoaDaoTao (
                                idVeSiKhoaDaoTao INT AUTO_INCREMENT,
                                idKhoaDaoTao INT,
                                idVeSi INT,
                                ngayHoanThanh DATE,
                                diem FLOAT,
                                chungChi VARCHAR(255),
                                trangThai ENUM('Chưa hoàn hành', 'Đang thực hiện', 'Hoàn thành', 'Đã hủy') NOT NULL,
                                ngayXoa DATETIME,
                                PRIMARY KEY (idVeSiKhoaDaoTao),
                                FOREIGN KEY (idKhoaDaoTao) REFERENCES KhoaDaoTao(idKhoaDaoTao) ON DELETE CASCADE,
                                FOREIGN KEY (idVeSi) REFERENCES VeSi(idVeSi) ON DELETE CASCADE
);

CREATE INDEX idx_vesikhoadaotao_khoadaotao ON VeSiKhoaDaoTao (idKhoaDaoTao);
CREATE INDEX idx_vesikhoadaotao_vesi ON VeSiKhoaDaoTao (idVeSi);
CREATE INDEX idx_vesikhoadaotao_ngayxoa ON VeSiKhoaDaoTao (ngayXoa);

-- Bảng YeuCauHoTro c3
CREATE TABLE YeuCauHoTro (
                             idYeuCauHoTro INT AUTO_INCREMENT,
                             idNhanVien INT,
                             idNguoiDung INT,
                             loaiYeuCau VARCHAR(255),
                             noiDungYeuCau VARCHAR(255),
                             tepDinhKem VARCHAR(255),
                             noiDungPhanHoi VARCHAR(255),
                             trangThai ENUM('Chưa hoàn hành', 'Đang thực hiện', 'Hoàn thành', 'Đã hủy') NOT NULL,
                             ngayXoa DATETIME,
                             PRIMARY KEY (idYeuCauHoTro),
                             FOREIGN KEY (idNhanVien) REFERENCES NhanVien(idNhanVien) ON DELETE CASCADE,
                             FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(idNguoiDung) ON DELETE CASCADE
);

CREATE INDEX idx_yeucauhotro_nhanvien ON YeuCauHoTro (idNhanVien);
CREATE INDEX idx_yeucauhotro_ngayxoa ON YeuCauHoTro (ngayXoa);

-- Bảng NhiemVu c4
CREATE TABLE NhiemVu (
                         idNhiemVu INT AUTO_INCREMENT,
                         idHopDong INT,
                         idVeSi INT,
                         ngayBatDau DATE,
                         ngayKetThuc DATE,
                         capBac VARCHAR(255),
                         noiDung VARCHAR(255),
                         danhGiaKyNangChuyenMon INT,
                         danhGiaXuLyTinhHuong INT,
                         danhGiaThaiDoDaoDuc INT,
                         danhGiaGiaoTiep INT,
                         danhGiaNgoaiHinh INT,
                         thongTinDanhGia VARCHAR(255),
                         trangThai ENUM('Chưa bắt đầu', 'Đang thực hiện', 'Hoàn thành', 'Tạm dừng') DEFAULT 'Chưa bắt đầu',
                         ngayXoa DATETIME,
                         PRIMARY KEY (idNhiemVu),
                         FOREIGN KEY (idHopDong) REFERENCES HopDong(idHopDong) ON DELETE CASCADE,
                         FOREIGN KEY (idVeSi) REFERENCES VeSi(idVeSi) ON DELETE CASCADE
);

CREATE INDEX idx_nhiemvu_hopdong ON NhiemVu (idHopDong);
CREATE INDEX idx_nhiemvu_vesi ON NhiemVu (idVeSi);
CREATE INDEX idx_nhiemvu_ngayxoa ON NhiemVu (ngayXoa);

-- Bảng ThongBaoNguoiDung c4
CREATE TABLE ThongBaoNguoiDung (
                                   idThongBaoNguoiDung INT AUTO_INCREMENT,
                                   idThongBao INT,
                                   idNguoiDung INT,
                                   thoiGianDoc DATETIME,
                                   ngayXoa DATETIME,
                                   PRIMARY KEY (idThongBaoNguoiDung),
                                   FOREIGN KEY (idThongBao) REFERENCES ThongBao(idThongBao) ON DELETE CASCADE,
                                   FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(idNguoiDung) ON DELETE CASCADE
);

CREATE INDEX idx_thongbaonguoidung_thongbao ON ThongBaoNguoiDung (idThongBao);
CREATE INDEX idx_thongbaonguoidung_ngayxoa ON ThongBaoNguoiDung (ngayXoa);

-- Bảng HoaDon c4
CREATE TABLE HoaDon (
                        idHoaDon INT AUTO_INCREMENT,
                        idHopDong INT,
                        ngayLap DATE,
                        tongTien DECIMAL(18,2),
                        phuongThucThanhToan ENUM('Tiền mặt', 'Chuyển khoản', 'Thẻ tín dụng') DEFAULT 'Tiền mặt',
                        trangThai ENUM('Chưa thanh toán', 'Đã thanh toán', 'Đã hủy') DEFAULT 'Chưa thanh toán',
                        ngayXoa DATETIME,
                        PRIMARY KEY (idHoaDon),
                        FOREIGN KEY (idHopDong) REFERENCES HopDong(idHopDong) ON DELETE CASCADE
);

CREATE INDEX idx_hoadon_hopdong ON HoaDon (idHopDong);
CREATE INDEX idx_hoadon_ngayxoa ON HoaDon (ngayXoa);
CREATE INDEX idx_hoadon_phuongthucthanhtoan ON HoaDon (phuongThucThanhToan);
CREATE INDEX idx_hoadon_trangthai ON HoaDon (trangThai);

-- Bảng TepHopDong c4
CREATE TABLE TepHopDong (
                            idTepHopDong INT AUTO_INCREMENT,
                            idHopDong INT,
                            loaiTep ENUM('Hợp đồng chính', 'Hình ảnh', 'Chứng từ', 'Biên bản ký kết', 'Chứng nhận pháp lý', 'Khác') NOT NULL,
                            tepDinhKem VARCHAR(255),
                            PRIMARY KEY (idTepHopDong),
                            FOREIGN KEY (idHopDong) REFERENCES HopDong(idHopDong) ON DELETE CASCADE
);

CREATE INDEX idx_tephopdong_hopdong ON TepHopDong (idHopDong);
CREATE INDEX idx_tephopdong_loaitep ON TepHopDong (loaiTep);

-- Bảng BaoCaoKhanNhiemVu c5
CREATE TABLE BaoCaoKhanNhiemVu (
                                   idBaoCaoKhan INT AUTO_INCREMENT,
                                   idNhiemVu INT,
                                   idNhanVien INT,
                                   noiDung VARCHAR(255),
                                   mucDoKhanCap ENUM('Cao', 'Trung Bình', 'Thấp') NOT NULL,
                                   trangThai ENUM('Chưa hoàn thành', 'Đang thực hiện', 'Hoàn thành', 'Đã hủy') NOT NULL,
                                   ngayXoa DATETIME,
                                   PRIMARY KEY (idBaoCaoKhan),
                                   FOREIGN KEY (idNhiemVu) REFERENCES NhiemVu(idNhiemVu) ON DELETE CASCADE,
                                   FOREIGN KEY (idNhanVien) REFERENCES NhanVien(idNhanVien) ON DELETE CASCADE
);

CREATE INDEX idx_baocaokhannhiemvu_nhiemvu ON BaoCaoKhanNhiemVu (idNhiemVu);
CREATE INDEX idx_baocaokhannhiemvu_nhanvien ON BaoCaoKhanNhiemVu (idNhanVien);
CREATE INDEX idx_baocaokhannhiemvu_ngayxoa ON BaoCaoKhanNhiemVu (ngayXoa);

-- Dữ liệu mẫu:

INSERT INTO VaiTro (tenVaiTro, capBac, moTa)
VALUES
    ('KhachHang', 'N/A', 'Khách hàng là người sử dụng dịch vụ của công ty'),
    ('VeSi', 'N/A', 'Vệ sĩ chịu trách nhiệm bảo vệ tài sản và an ninh của công ty'),
    ('NhanVien', 'Nhân viên', 'Nhân viên công ty làm các công việc hành chính và hỗ trợ khách hàng'),
    ('Admin', 'Quản trị viên', 'Người quản lý toàn bộ hệ thống, có quyền cao nhất trong việc quản lý người dùng và các dịch vụ');

-- Dữ liệu bảng NguoiDung
INSERT INTO NguoiDung (tenDangNhap, matKhau, anhDaiDien, hoTen, gioiTinh, ngaySinh, email, soDienThoai, soCCCD, diaChi, trangThai)
VALUES
    ('khachhang1', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image1.jpg', 'Nguyễn Văn A', 'Nam', '1990-01-01', 'khachhang1@example.com', '0123456789', '1234567890', 'Số 10, phố X, Quận Hoàn Kiếm, Hà Nội', 'Hoạt động'),
    ('khachhang2', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image2.jpg', 'Trần Thị B', 'Nữ', '1991-02-01', 'khachhang2@example.com', '0123456790', '1234567891', 'Số 22, phố Y, Quận 1, TP. Hồ Chí Minh', 'Hoạt động'),
    ('khachhang3', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image3.jpg', 'Lê Thị C', 'Nữ', '1992-03-01', 'khachhang3@example.com', '0123456791', '1234567892', 'Số 45, đường Z, Đà Nẵng', 'Hoạt động'),
    ('khachhang4', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image4.jpg', 'Nguyễn Thị D', 'Nữ', '1993-04-01', 'khachhang4@example.com', '0123456792', '1234567893', 'Số 13, đường A, Quận Ba Đình, Hà Nội', 'Hoạt động'),
    ('khachhang5', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image5.jpg', 'Phạm Minh E', 'Nam', '1994-05-01', 'khachhang5@example.com', '0123456793', '1234567894', 'Số 89, đường B, TP. Hồ Chí Minh', 'Hoạt động'),
    ('khachhang6', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image6.jpg', 'Hoàng Thị F', 'Nữ', '1995-06-01', 'khachhang6@example.com', '0123456794', '1234567895', 'Số 55, phố C, Cần Thơ', 'Hoạt động'),
    ('khachhang7', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image7.jpg', 'Nguyễn Thị G', 'Nữ', '1996-07-01', 'khachhang7@example.com', '0123456795', '1234567896', 'Số 21, đường D, Vũng Tàu', 'Hoạt động'),
    ('khachhang8', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image8.jpg', 'Trịnh Minh H', 'Nam', '1997-08-01', 'khachhang8@example.com', '0123456796', '1234567897', 'Số 10, phố E, Huế', 'Hoạt động'),
    ('khachhang9', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image9.jpg', 'Vũ Thị I', 'Nữ', '1998-09-01', 'khachhang9@example.com', '0123456797', '1234567898', 'Số 33, đường F, Nha Trang', 'Hoạt động'),
    ('khachhang10', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image10.jpg', 'Đỗ Thị J', 'Nữ', '1999-10-01', 'khachhang10@example.com', '0123456798', '1234567899', 'Số 15, đường G, Quận 7, TP. Hồ Chí Minh', 'Hoạt động'),
    ('vesi1', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image1.jpg', 'Nguyễn Minh A', 'Nam', '1990-01-01', 'vesi1@example.com', '0123456801', '1234567801', 'Số 12, phố X, Quận Hoàn Kiếm, Hà Nội', 'Hoạt động'),
    ('vesi2', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image2.jpg', 'Phạm Thị B', 'Nữ', '1991-02-01', 'vesi2@example.com', '0123456802', '1234567802', 'Số 30, đường Y, TP. Hồ Chí Minh', 'Hoạt động'),
    ('vesi3', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image3.jpg', 'Lê Thị C', 'Nữ', '1992-03-01', 'vesi3@example.com', '0123456803', '1234567803', 'Số 50, đường Z, Đà Nẵng', 'Hoạt động'),
    ('vesi4', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image4.jpg', 'Nguyễn Thị D', 'Nữ', '1993-04-01', 'vesi4@example.com', '0123456804', '1234567804', 'Số 21, đường A, Quận Ba Đình, Hà Nội', 'Hoạt động'),
    ('vesi5', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image5.jpg', 'Phạm Minh E', 'Nam', '1994-05-01', 'vesi5@example.com', '0123456805', '1234567805', 'Số 89, đường B, TP. Hồ Chí Minh', 'Hoạt động'),
    ('vesi6', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image6.jpg', 'Hoàng Thị F', 'Nữ', '1995-06-01', 'vesi6@example.com', '0123456806', '1234567806', 'Số 65, phố C, Cần Thơ', 'Hoạt động'),
    ('vesi7', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image7.jpg', 'Nguyễn Thị G', 'Nữ', '1996-07-01', 'vesi7@example.com', '0123456807', '1234567807', 'Số 33, đường D, Vũng Tàu', 'Hoạt động'),
    ('vesi8', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image8.jpg', 'Trịnh Minh H', 'Nam', '1997-08-01', 'vesi8@example.com', '0123456808', '1234567808', 'Số 15, phố E, Huế', 'Hoạt động'),
    ('vesi9', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image9.jpg', 'Vũ Thị I', 'Nữ', '1998-09-01', 'vesi9@example.com', '0123456809', '1234567809', 'Số 25, đường F, Nha Trang', 'Hoạt động'),
    ('vesi10', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image10.jpg', 'Đỗ Thị J', 'Nữ', '1999-10-01', 'vesi10@example.com', '0123456810', '1234567810', 'Số 18, đường G, Quận 7, TP. Hồ Chí Minh', 'Hoạt động'),
    ('admin1', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image1.jpg', 'Nguyễn Văn A', 'Nam', '1985-01-01', 'admin1@example.com', '0123456811', '1234567811', 'Số 1, phố Admin, Quận Hoàn Kiếm, Hà Nội', 'Hoạt động'),
    ('admin2', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image2.jpg', 'Trần Thị B', 'Nữ', '1986-02-01', 'admin2@example.com', '0123456812', '1234567812', 'Số 2, phố Admin, Quận 1, TP. Hồ Chí Minh', 'Hoạt động'),
    ('admin3', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image3.jpg', 'Lê Thị C', 'Nữ', '1987-03-01', 'admin3@example.com', '0123456813', '1234567813', 'Số 3, phố Admin, Đà Nẵng', 'Hoạt động'),
    ('admin4', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image4.jpg', 'Nguyễn Thị D', 'Nữ', '1988-04-01', 'admin4@example.com', '0123456814', '1234567814', 'Số 4, đường Admin, Quận Ba Đình, Hà Nội', 'Hoạt động'),
    ('admin5', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image5.jpg', 'Phạm Minh E', 'Nam', '1989-05-01', 'admin5@example.com', '0123456815', '1234567815', 'Số 5, đường Admin, TP. Hồ Chí Minh', 'Hoạt động'),
    ('admin6', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image6.jpg', 'Hoàng Thị F', 'Nữ', '1990-06-01', 'admin6@example.com', '0123456816', '1234567816', 'Số 6, phố Admin, Cần Thơ', 'Hoạt động'),
    ('admin7', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image7.jpg', 'Nguyễn Thị G', 'Nữ', '1991-07-01', 'admin7@example.com', '0123456817', '1234567817', 'Số 7, đường Admin, Vũng Tàu', 'Hoạt động'),
    ('admin8', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image8.jpg', 'Trịnh Minh H', 'Nam', '1992-08-01', 'admin8@example.com', '0123456818', '1234567818', 'Số 8, phố Admin, Huế', 'Hoạt động'),
    ('admin9', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image9.jpg', 'Vũ Thị I', 'Nữ', '1993-09-01', 'admin9@example.com', '0123456819', '1234567819', 'Số 9, đường Admin, Nha Trang', 'Hoạt động'),
    ('admin10', '$2a$07$F7aDuJ5vkcDvDBLvGkhd2uj4lXGxah.TENhwqXgD1UsfB/xO8nTg.', 'image10.jpg', 'Đỗ Thị J', 'Nữ', '1994-10-01', 'admin10@example.com', '0123456820', '1234567820', 'Số 10, đường Admin, Quận 7, TP. Hồ Chí Minh', 'Hoạt động');

-- Dữ liệu bảng NguoiDungVaiTro
INSERT INTO NguoiDungVaiTro (idNguoiDung, idVaiTro)
VALUES
    (1, 1),  -- khachhang1 với vai trò Khách Hàng
    (2, 1),  -- khachhang2 với vai trò Khách Hàng
    (3, 1),  -- khachhang3 với vai trò Khách Hàng
    (4, 1),  -- khachhang4 với vai trò Khách Hàng
    (5, 1),  -- khachhang5 với vai trò Khách Hàng
    (6, 1),  -- khachhang6 với vai trò Khách Hàng
    (7, 1),  -- khachhang7 với vai trò Khách Hàng
    (8, 1),  -- khachhang8 với vai trò Khách Hàng
    (9, 1),  -- khachhang9 với vai trò Khách Hàng
    (10, 1), -- khachhang10 với vai trò Khách Hàng
    (11, 2),  -- vesi1 với vai trò Vệ Sĩ
    (12, 2),  -- vesi2 với vai trò Vệ Sĩ
    (13, 2),  -- vesi3 với vai trò Vệ Sĩ
    (14, 2),  -- vesi4 với vai trò Vệ Sĩ
    (15, 2),  -- vesi5 với vai trò Vệ Sĩ
    (16, 2),  -- vesi6 với vai trò Vệ Sĩ
    (17, 2),  -- vesi7 với vai trò Vệ Sĩ
    (18, 2),  -- vesi8 với vai trò Vệ Sĩ
    (19, 2),  -- vesi9 với vai trò Vệ Sĩ
    (20, 2), -- vesi10 với vai trò Vệ Sĩ
    (21, 3),  -- admin1 với vai trò Admin
    (22, 3),  -- admin2 với vai trò Admin
    (23, 3),  -- admin3 với vai trò Admin
    (24, 3),  -- admin4 với vai trò Admin
    (25, 3),  -- admin5 với vai trò Admin
    (26, 3),  -- admin6 với vai trò Admin
    (27, 3),  -- admin7 với vai trò Admin
    (28, 3),  -- admin8 với vai trò Admin
    (29, 3),  -- admin9 với vai trò Admin
    (30, 3); -- admin10 với vai trò Admin

-- Dữ liệu bảng VeSi
INSERT INTO VeSi (idNguoiDung, kinhNghiem, thongTinDanhGiaChung, ngayBatDauLam, capBac, ngayLenCap, luong, trangThai)
VALUES
    (11, 5, 'Vệ sĩ có kinh nghiệm bảo vệ sự kiện lớn', '2020-01-01', 'Senior', '2022-06-01', 15000000.00, 'Hoạt động'),
    (12, 3, 'Vệ sĩ chuyên bảo vệ các cá nhân nổi tiếng', '2021-02-01', 'Mid-Level', '2023-04-01', 12000000.00, 'Hoạt động'),
    (13, 4, 'Vệ sĩ bảo vệ cho nhiều sự kiện thể thao', '2020-05-01', 'Senior', '2022-05-01', 13000000.00, 'Hoạt động'),
    (14, 6, 'Vệ sĩ bảo vệ các đoàn lãnh đạo cấp cao', '2019-08-01', 'Lead', '2022-07-01', 16000000.00, 'Hoạt động'),
    (15, 2, 'Vệ sĩ bảo vệ cho các doanh nhân', '2021-06-01', 'Junior', '2023-03-01', 11000000.00, 'Hoạt động'),
    (16, 4, 'Vệ sĩ bảo vệ cho sự kiện lớn', '2020-11-01', 'Mid-Level', '2022-09-01', 12500000.00, 'Hoạt động'),
    (17, 5, 'Vệ sĩ chuyên bảo vệ các đoàn khách VIP', '2021-01-01', 'Senior', '2023-02-01', 13500000.00, 'Hoạt động'),
    (18, 3, 'Vệ sĩ bảo vệ các công ty, hội nghị', '2021-03-01', 'Mid-Level', '2023-06-01', 12000000.00, 'Hoạt động'),
    (19, 4, 'Vệ sĩ bảo vệ cho các nhân vật công chúng', '2020-07-01', 'Lead', '2022-12-01', 14000000.00, 'Hoạt động'),
    (20, 5, 'Vệ sĩ bảo vệ cho các sự kiện thể thao lớn', '2020-10-01', 'Senior', '2023-01-01', 15000000.00, 'Hoạt động');

-- Dữ liệu bảng NhanVien
INSERT INTO NhanVien (idNguoiDung, ngayBatDauLam, capBac, ngayLenCap, luong, trangThai)
VALUES
    (21, '2015-01-01', 'Admin', '2020-01-01', 25000000.00, 'Hoạt động'),
    (22, '2016-02-01', 'Admin', '2021-05-01', 23000000.00, 'Hoạt động'),
    (23, '2017-03-01', 'Manager', '2022-08-01', 22000000.00, 'Hoạt động'),
    (24, '2014-04-01', 'Senior Admin', '2021-11-01', 27000000.00, 'Hoạt động'),
    (25, '2018-05-01', 'Admin', '2022-06-01', 24000000.00, 'Hoạt động'),
    (26, '2019-06-01', 'Admin', '2023-03-01', 25000000.00, 'Hoạt động'),
    (27, '2020-07-01', 'Manager', '2023-07-01', 22000000.00, 'Hoạt động'),
    (28, '2016-08-01', 'Admin', '2021-12-01', 23000000.00, 'Hoạt động'),
    (29, '2015-09-01', 'Senior Admin', '2022-09-01', 28000000.00, 'Hoạt động'),
    (30, '2017-10-01', 'Admin', '2023-05-01', 24000000.00, 'Hoạt động');

-- Dữ liệu bảng DanhMucDichVu
INSERT INTO DanhMucDichVu (tenDichVu, moTa, giaDuKien, ngayXoa)
VALUES
    ('Bảo vệ cá nhân', 'Cung cấp dịch vụ bảo vệ cá nhân cho khách hàng', 10000000, NULL),
    ('Bảo vệ sự kiện', 'Dịch vụ bảo vệ cho các sự kiện lớn hoặc hội nghị', 15000000, NULL),
    ('Bảo vệ sân bay', 'Dịch vụ bảo vệ tại các sân bay', 20000000, NULL),
    ('Bảo vệ vận chuyển', 'Dịch vụ bảo vệ cho các chuyến vận chuyển hàng hóa và tài sản', 12000000, NULL);

-- Dữ liệu bảng YeuCauDichVu
INSERT INTO YeuCauDichVu (idNguoiDung, idDanhMucDichVu, hoTenKhachHang, soDienThoai, anh, soCCCD, diaDiem, soLuongVeSi, ngayBatDau, ngayKetThuc, giaTienDuKien, ghiChu, noiDungTraLoi, trangThai)
VALUES
    (1, 1, 'Nguyễn Văn A', '0901234567', 'avatar.jpg', '123456789', 'Hà Nội', 5, '2024-12-10', '2024-12-12', 20000000.00, 'Bảo vệ sự kiện hội nghị', 'Dịch vụ bảo vệ sự kiện sẽ được cung cấp', 'Chưa xác nhận'),
    (2, 2, 'Trần Thị B', '0902345678', 'avatar2.jpg', '234567890', 'Hồ Chí Minh', 3, '2024-12-11', '2024-12-13', 15000000.00, 'Bảo vệ sự kiện thể thao', 'Đang xác nhận dịch vụ', 'Đang xử lý'),
    (3, 3, 'Phan Minh C', '0903456789', 'avatar3.jpg', '345678901', 'Đà Nẵng', 2, '2024-12-12', '2024-12-14', 10000000.00, 'Bảo vệ sân bay', 'Chúng tôi sẽ cung cấp dịch vụ bảo vệ sân bay', 'Chưa xác nhận'),
    (4, 4, 'Lê Thị D', '0904567890', 'avatar4.jpg', '456789012', 'Cần Thơ', 4, '2024-12-13', '2024-12-15', 18000000.00, 'Bảo vệ vận chuyển hàng hóa', 'Yêu cầu bảo vệ cho lô hàng quốc tế', 'Chưa xác nhận');




