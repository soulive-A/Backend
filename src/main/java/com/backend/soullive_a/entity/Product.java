package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long id;

    @Column(name = "COMPANY", nullable = false)
    private String company;

    @Column(name = "BRAND", nullable = true)
    private String brand;

    @Column(name = "PRODUCT", nullable = false)
    private String product;

    @Column(name = "CHARACTERISTIC", nullable = false)
    private String characteristic;
}
