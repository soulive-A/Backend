package com.backend.soullive_a.repository.model.popularity;

import com.backend.soullive_a.entity.model.popularity.ModelPopularGender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelPopularGenderRepository extends JpaRepository<ModelPopularGender, Long> {

    List<ModelPopularGender> findAllByModelPopularityModelModelName(String name);

}
