package com.backend.soullive_a.entity.model.fitness;

import com.backend.soullive_a.entity.model.ProductModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelFitness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_FITENSS_ID", nullable = false)
    private Long id;

    @Column(name = "SCORE_URL", nullable = false)
    private String scoreUrl;

    @Column(name = "AI_COMMENT", nullable = false)
    private String aiComment;

    @OneToOne
    @JoinColumn(name = "PRODUCT_MODEL_ID")
    private ProductModel productModel;
}
