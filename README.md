# Tổng hợp công cụ, thư viện và mục đích sử dụng trong dự án

Dự án sử dụng các công cụ và thư viện Java phổ biến để xây dựng ứng dụng backend mạnh mẽ, bảo mật và dễ bảo trì. Dưới
đây là tổng hợp các công cụ chính và mục đích sử dụng của chúng:

---

1. **Framework & Thư viện chính**
    - **Spring Boot**: Khởi tạo, cấu hình và chạy ứng dụng backend.
    - **Spring Web**: Xây dựng REST API, xử lý HTTP request/response.
    - **Spring Data JPA**: ORM, truy vấn và thao tác dữ liệu với MySQL.
    - **Spring Security**: Bảo mật, xác thực, phân quyền, hỗ trợ OAuth2.
    - **Spring Validation**: Kiểm tra dữ liệu đầu vào, xác thực dữ liệu khi nhận request.
    - **Spring Mail**: Gửi email qua SMTP (Gmail), dùng cho xác thực, thông báo, quên mật khẩu.
    - **Spring Web Services**: Hỗ trợ SOAP web service nếu cần tích hợp hệ thống ngoài.
    - **Spring OAuth2 Resource Server & Client**: Đăng nhập Google, xác thực OAuth2 cho người dùng.

2. **Thư viện bổ trợ**
    - **Lombok**: Giảm code lặp (tự động sinh getter/setter, constructor, builder...).
    - **MapStruct**: Mapping giữa DTO và Entity, giúp chuyển đổi dữ liệu giữa các tầng.
    - **Thymeleaf**: Template engine cho email, giao diện động (ví dụ: gửi email HTML).
    - **Thymeleaf Extras Spring Security**: Tích hợp bảo mật với Thymeleaf, kiểm tra quyền trong template.
    - **Cloudinary**: Lưu trữ và quản lý ảnh/video trên cloud, phục vụ upload/download media.
    - **JJWT (io.jsonwebtoken)**: Tạo và xác thực JWT cho API, bảo mật truy cập không trạng thái.
    - **MySQL Connector/J**: Kết nối cơ sở dữ liệu MySQL từ Java.
    - **Google API Client & OAuth Client**: Tích hợp dịch vụ Google, đăng nhập Google OAuth2.

3. **Công cụ phát triển & kiểm thử**
    - **Spring Boot Devtools**: Hỗ trợ hot reload khi phát triển, tự động cập nhật khi thay đổi code.
    - **Spring Boot Starter Test, Spring Security Test**: Viết unit test, kiểm thử bảo mật, đảm bảo chất lượng code.
    - **Jakarta Servlet API**: Hỗ trợ servlet cho web, xử lý request/response ở tầng thấp.
    - **Springdoc OpenAPI**: Tự động sinh tài liệu API (Swagger UI), giúp kiểm thử và tích hợp API dễ dàng.

4. **Công cụ format code & build**
    - **Spotless Maven Plugin**: Format code Java tự động, xóa import thừa, chuẩn hóa indent, thứ tự import, trim
      whitespace, v.v. Giúp code luôn sạch, chuẩn hóa theo quy tắc định sẵn.
    - **Maven Compiler Plugin**: Biên dịch mã nguồn Java, hỗ trợ Java 17, có thể bật tính năng preview.
    - **Spring Boot Maven Plugin**: Build và chạy ứng dụng Spring Boot, đóng gói thành file jar/war.
    - **Maven Surefire Plugin**: Chạy unit test tự động khi build.

5. **Các package trong src/main/java**
    - **configuration/**: Cấu hình ứng dụng, bảo mật, Cloudinary, VNPay, JWT, v.v.
    - **controller/**: Xử lý các request HTTP cho các chức năng (người dùng, hợp đồng, hóa đơn, email, hình ảnh, báo
      cáo, v.v.).
    - **dto/**: Định nghĩa các đối tượng truyền dữ liệu giữa các tầng (request/response).
    - **entity/**: Định nghĩa các bảng dữ liệu, ánh xạ ORM với JPA/Hibernate.
    - **repository/**: Truy vấn, thao tác dữ liệu với JPA.
    - **service/**: Xử lý nghiệp vụ, logic chính của hệ thống.
    - **util/**, **validator/**: Các hàm tiện ích, kiểm tra dữ liệu đầu vào, custom validation.
    - **mapper/**: MapStruct mapping giữa DTO và Entity, chuyển đổi dữ liệu giữa các tầng.

---

**Tóm tắt mục đích từng công cụ:**

- Xây dựng backend REST API, bảo mật, xác thực, phân quyền, quản lý dữ liệu, gửi email, lưu trữ media, thanh toán, đăng
  nhập Google, sinh tài liệu API, kiểm thử, format code tự động, build và deploy ứng dụng.
