package com.backend.soullive_a.entity.model.popularity;

import com.backend.soullive_a.constant.GenderType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MODEL_POPULAR_GENDER")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelPopularGender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_POPULARITY_ID", nullable = false)
    private ModelPopularity modelPopularity;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER_TYPE")
    private GenderType gender;
}