package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "loai_phong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class LoaiPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String ma;
    private String ten;
}
