package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BRAND_IMAGE")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandImage {
    @Id
    @GeneratedValue
    @Column(name = "BRAND_IMAGE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Column(name = "BRAND_IMAGE")
    private String brandImage;
}
