package com.backend.soullive_a.repository.model.popularity;

import com.backend.soullive_a.entity.model.popularity.ModelPopularity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelPopularityRepository extends JpaRepository<ModelPopularity, Long> {

    ModelPopularity findByModelModelName(String name);

}
