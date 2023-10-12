package com.example.lab2.respon;

import com.example.lab2.model.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PhongRespon extends JpaRepository<Phong, UUID> {
}
