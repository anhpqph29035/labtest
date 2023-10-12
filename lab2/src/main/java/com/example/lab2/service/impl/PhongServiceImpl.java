package com.example.lab2.service.impl;

import com.example.lab2.model.Phong;
import com.example.lab2.respon.PhongRespon;
import com.example.lab2.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PhongServiceImpl implements PhongService {
    @Autowired
    PhongRespon pr;
    @Override
    public Page<Phong> getList(int page) {
        Pageable pageable= PageRequest.of(page,2);
        return pr.findAll(pageable);
    }

    @Override
    public void add(Phong p) {
        pr.save(p);
    }

    @Override
    public void delete(UUID id) {
        pr.deleteById(id);
    }

    @Override
    public Phong getPhong(UUID id) {
        return pr.getById(id);
    }
}
