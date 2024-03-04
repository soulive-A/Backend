package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelRecentWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_RECENT_WORK_ID", nullable = false)
    private Long id;

    @Column(name = "YEAR", nullable = false)
    private Integer year;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "GENRE", nullable = false)
    private String genre;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @Column(name = "IS_MAIN_ACTOR", nullable = false)
    private Boolean isMainActor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_ID", nullable = false)
    private Model model;
}
