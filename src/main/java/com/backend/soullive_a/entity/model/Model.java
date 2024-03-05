package com.backend.soullive_a.entity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_ID", nullable = false)
    private Long id;

    @Column(name = "IMAGE_URL", nullable = false)
    private String imageUrl;

    @Column(name = "MODEL_NAME", nullable = false)
    private String modelName;

    @Column(name = "BIRTH", nullable = false)
    private LocalDate birth;

    @Column(name = "AGE", nullable = false)
    private String age;

    @Column(name = "JOB", nullable = false)
    private String job;

    @Column(name = "INFO")
    private String info;

    @Column(name = "AGENCY", nullable = false)
    private String agency;

    @Column(name = "AI_RATE", nullable = false)
    private Float aiRate;
}
