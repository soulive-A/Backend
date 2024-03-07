package com.backend.soullive_a.entity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @Column(name = "BIRTH")
    private LocalDate birth;


    @Column(name = "AGE")
    private String age;

    @Column(name = "JOB")
    private String job;

    @Column(name = "INFO")
    private String info;

    @Column(name = "AGENCY")
    private String agency;

    @Column(name = "AI_RATE")
    private Float aiRate;
}
