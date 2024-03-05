package com.backend.soullive_a.entity.model.popularity;

import com.backend.soullive_a.entity.model.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MODEL_SCHEDULED_WORK")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelScheduledWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_SCHEDULED_WORK_ID", nullable = false)
    private Long id;

    @JoinColumn(name = "IMAGE_URL")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_POPULARITY_ID", nullable = false)
    private ModelPopularity modelPopularity;

    @Column(name = "YEAR", nullable = false)
    private Integer year;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "IS_MAIN_ACTOR", nullable = false)
    private Boolean isMainActor;

    @Column(name = "GENRE", nullable = false)
    private String genre;
}
