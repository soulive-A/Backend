package com.backend.soullive_a.entity;

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
    private Long modelRecentAdvertisementId;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
