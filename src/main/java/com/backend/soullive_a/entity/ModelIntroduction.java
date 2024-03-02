package com.backend.soullive_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelIntroduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "model_id") //식별
    private Model model;

//    @Builder
//    public ModelIntroduction(Model model) {
//        this.model = model;
//    }
}
