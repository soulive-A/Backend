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
    private Long modelImageKeywordId;

    @ManyToOne
    @JoinColumn(name = "model_id") //비식별인데..
    private Model model;
    private String keyword;


//    @Builder
//    public ModelImageKeyword(Model model, String keyword) {
//        this.model = model;
//        this.keyword = keyword;
//    }
}
