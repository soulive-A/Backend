package com.backend.soullive_a.entity.model.introduction;

import com.backend.soullive_a.entity.model.Model;
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
    @Column(name = "MODEL_IMAGE_KEYWORD_ID", nullable = false)
    private Long id;

    @Column(name = "KEYWORD", nullable = false)
    private String keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_ID", nullable = false)
    private Model model;
}
