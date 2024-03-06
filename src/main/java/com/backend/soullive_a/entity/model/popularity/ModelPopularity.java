package com.backend.soullive_a.entity.model.popularity;

import com.backend.soullive_a.entity.model.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MODEL_POPULARITY")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelPopularity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_POPULARITY_ID", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "MODEL_ID", nullable = false)
    private Model model;

    @Column(name = "SCORE_URL")
    private String scoreUrl;

    @Column(name = "AI_COMMENT")
    private String aiComment;

    @Column(name = "SNS_URL")
    private String snsUrl;

    @Column(name = "SEARCH_URL")
    private String searchUrl;

    @Column(name = "BRAND_SCORE_URL")
    private String brandScoreUrl;
}
