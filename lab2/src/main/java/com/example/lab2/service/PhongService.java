package com.example.lab2.service;

import com.example.lab2.model.Phong;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PhongService {
    Page<Phong> getList(int page);
    void add(Phong p);
    void delete(UUID id);
    Phong getPhong(UUID id);
}
