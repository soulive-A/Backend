package com.backend.soullive_a.repository;

import com.backend.soullive_a.dto.response.ModelRecommendResponse;
import com.backend.soullive_a.entity.model.Model;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface ModelRepository extends JpaRepository<Model, Long> {

    public Optional<Model> findByModelName(String modelName);

    @Query("select "
        + "new com.backend.soullive_a.dto.response.ModelRecommendResponse(m.imageUrl,m.modelName,m.job) "
        + "From Model m ")
    List<ModelRecommendResponse> findAllRecommendModel();
}
