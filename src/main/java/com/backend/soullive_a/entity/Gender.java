package com.backend.soullive_a.entity;

import com.backend.soullive_a.constant.GenderType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GENDER")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gender {
    @Id
    @GeneratedValue
    @Column(name = "GENDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER_TYPE")
    private GenderType gender;
}