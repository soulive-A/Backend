package com.backend.soullive_a.entity;

import com.backend.soullive_a.constant.AgeType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "AGE")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Age {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AGE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "AGE_TYPE")
    private AgeType age;
}