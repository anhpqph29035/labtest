package com.example.lab2.respon;

import com.example.lab2.model.LoaiPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@Repository
public interface LoaiPhongRespon extends JpaRepository<LoaiPhong, UUID> {
}
