package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "MODEL_NAME", nullable = false)
    private String modelName;

    @Column(name = "BIRTH", nullable = false)
    private LocalDateTime birth;

    @Column(name = "JOB", nullable = false)
    private String job;

    @Column(name = "INFO", nullable = false)
    private String info;

    @Column(name = "AGENCY", nullable = false)
    private String agency;

    @Column(name = "AI_RATE", nullable = false)
    private Float aiRate;
}
