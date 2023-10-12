package com.example.lab2.service.impl;

import com.example.lab2.model.LoaiPhong;
import com.example.lab2.respon.LoaiPhongRespon;
import com.example.lab2.service.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiPhongServiceImpl implements LoaiPhongService {
    @Autowired
    LoaiPhongRespon lpr;
    @Override
    public List<LoaiPhong> getList() {
        return lpr.findAll();
    }
}
