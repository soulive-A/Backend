package com.backend.soullive_a.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
    private Integer age;

//    @Builder
//    public Model(Long modelId,String modelName,Integer age) {
//        this.modelId = modelId;
//        this.modelName = modelName;
//        this.age = age;
//    }

}
