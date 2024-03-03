package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
