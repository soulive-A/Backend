package com.backend.soullive_a.repository.model.popularity;

import com.backend.soullive_a.entity.model.popularity.ModelScheduledWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelScheduledWorkRepository extends JpaRepository<ModelScheduledWork, Long> {

    List<ModelScheduledWork> findAllByModelPopularityModelModelName(String name);

}
