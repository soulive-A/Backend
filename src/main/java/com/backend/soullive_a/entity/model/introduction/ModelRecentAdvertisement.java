package com.backend.soullive_a.entity.model.introduction;

import com.backend.soullive_a.entity.model.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelRecentAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_RECENT_ADVERTISEMENT_ID", nullable = false)
    private Long id;

    @Column(name = "YEAR", nullable = false)
    private Integer year;

    @Column(name = "BRAND", nullable = false)
    private String brand;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_ID", nullable = false)
    private Model model;
}
