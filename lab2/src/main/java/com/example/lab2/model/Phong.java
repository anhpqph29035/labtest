package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "phong")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "loai_phong_id")
    private LoaiPhong loaiPhong;
    private String ma;
    private String ten;
    private int soLuong;
    private String ghiChu;
    private int trangThai;

}
