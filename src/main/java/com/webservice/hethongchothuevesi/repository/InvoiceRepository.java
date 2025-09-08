package com.webservice.hethongchothuevesi.repository;

import com.webservice.hethongchothuevesi.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    // Các phương thức tùy chỉnh nếu cần
}
