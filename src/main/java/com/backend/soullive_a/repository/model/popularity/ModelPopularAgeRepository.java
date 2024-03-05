package com.backend.soullive_a.repository.model.popularity;

import com.backend.soullive_a.entity.model.popularity.ModelPopularAge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelPopularAgeRepository extends JpaRepository<ModelPopularAge, Long> {

    List<ModelPopularAge> findAllByModelPopularityModelModelName(String name);

}
