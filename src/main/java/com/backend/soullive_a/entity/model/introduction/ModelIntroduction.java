package com.backend.soullive_a.entity.model.introduction;

import com.backend.soullive_a.entity.model.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelIntroduction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_INTRODUCTION_ID", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "MODEL_ID", nullable = false) //식별 관계
    private Model model;
}
