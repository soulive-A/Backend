package com.backend.soullive_a.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelId;

    private String modelName;

    private LocalDate birth;

    private String job;

    private String info;

    private String agency;



}
