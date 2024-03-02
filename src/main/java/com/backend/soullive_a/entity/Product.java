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

@Slf4j
@Entity
@Table(name = "PRODUCT")
@Builder
@Getter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "COMPANY", length = 100)
    private String company;

    @Column(name = "BRAND", length = 100)
    private String brand;

    @OneToMany(mappedBy = "PRODUCT")
    private List<BrandImage> brandImages = new ArrayList<>();

    @Column(name = "PRODUCT", length = 100)
    private String product;

    @Column(name = "CHARACTERISTIC")
    private String characteristic;

    @OneToMany(mappedBy = "PRODUCT_IMAGE")
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToMany(mappedBy = "GENDER")
    private List<Gender> genders = new ArrayList<>();

    @OneToMany(mappedBy = "AGE")
    private List<Age> ages = new ArrayList<>();

    @OneToMany(mappedBy = "range")
    private List<Range> ranges = new ArrayList<>();
}
