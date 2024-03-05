package com.backend.soullive_a.entity.model.popularity;

import com.backend.soullive_a.constant.AgeType;
import com.backend.soullive_a.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MODEL_POPULAR_AGE")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelPopularAge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AGE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_POPULARITY_ID", nullable = false)
    private ModelPopularity modelPopularity;

    @Enumerated(EnumType.STRING)
    @Column(name = "AGE_TYPE")
    private AgeType age;
}
