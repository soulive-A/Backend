package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;

@Slf4j
@Entity(name = "RANGE")
@Builder
@Getter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Range {
    @Id
    @GeneratedValue
    @Column(name = "RANGE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Column(name = "RANGE")
    private String rangeType;
}
