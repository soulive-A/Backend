package com.backend.soullive_a.entity;

import com.backend.soullive_a.constant.GenderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "GENDER")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
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