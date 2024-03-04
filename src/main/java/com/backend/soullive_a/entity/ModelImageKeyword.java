package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ModelImageKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_IMAGE_KEYWORD_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "MODEL", nullable = false)
    private Model model;

    @Column(name = "KEYWORD", nullable = false)
    private String keyword;
}
