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
    private Long modelRecentWorkId;

    private Integer year;
    private String category;
    private String title;
    private String genre;
    private String role;
    private Boolean isMainActor;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
