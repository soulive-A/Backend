package com.backend.soullive_a.entity;

import com.backend.soullive_a.constant.GenderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;

@Slf4j
@Entity
@Table(name = "GENDER")
@Builder
@Getter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Gender {
    @Id
    @GeneratedValue
    @Column(name = "GENDER_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private GenderType gender;
}