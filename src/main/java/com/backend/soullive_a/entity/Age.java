package com.backend.soullive_a.entity;

import com.backend.soullive_a.constant.AgeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;

@Slf4j
@Entity
@Table(name = "AGE")
@Builder
@Getter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Age {
    @Id
    @GeneratedValue
    @Column(name = "AGE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "AGE_TYPE")
    private AgeType ageType;
}