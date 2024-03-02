package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;

@Slf4j
@Entity
@Table(name = "BRAND_IMAGE")
@Builder
@Getter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class BrandImage {
    @Id
    @GeneratedValue
    @Column(name = "BRAND_IMAGE_ID")
    private Long id;

    @Column(name = "BRAND_IMAGE")
    private String brandImage;
}
