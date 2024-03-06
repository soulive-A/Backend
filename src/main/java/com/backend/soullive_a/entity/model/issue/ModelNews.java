package com.backend.soullive_a.entity.model.issue;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ModelNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_NEWS_ID", nullable = false)
    private Long id;

    @Column(name = "COMPANY", nullable = false)
    private String  company;

    @Column(name = "NEWS_DATE", nullable = false)
    private LocalDate newsDate;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "NEWS_URL", nullable = false)
    private String newsUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_ISSUE_ID", nullable = false)
    private ModelIssue modelIssue;

}
