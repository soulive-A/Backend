package com.backend.soullive_a.repository;

import com.backend.soullive_a.entity.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ModelRepository extends JpaRepository<Model, Long> {
    public Optional<Model> findByModelName(String modelName);
}
