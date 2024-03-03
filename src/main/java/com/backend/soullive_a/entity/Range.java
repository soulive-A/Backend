package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TARGETRANGE")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Range {
    @Id
    @GeneratedValue
    @Column(name = "RANGE_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Column(name = "RANGE_VALUE", nullable = false)
    private String range;
}
