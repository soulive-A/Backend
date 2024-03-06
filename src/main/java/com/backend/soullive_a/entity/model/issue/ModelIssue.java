package com.backend.soullive_a.entity.model.issue;

import com.backend.soullive_a.entity.model.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ModelIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_ISSUE_ID", nullable = false)
    private Long id;

    @Column(name = "SCORE_URL", nullable = false)
    private String scoreUrl;

    @Column(name = "AI_COMMENT", nullable = false)
    private String aiComment;

    @Column(name = "CRIME", nullable = false)
    private Integer crime;

    @OneToOne
    @JoinColumn(name = "MODEL_ID", nullable = false)
    private Model model;
}
