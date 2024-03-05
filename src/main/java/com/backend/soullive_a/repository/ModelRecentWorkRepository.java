package com.backend.soullive_a.repository;

import com.backend.soullive_a.entity.model.Model;

import com.backend.soullive_a.entity.model.introduction.ModelRecentWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRecentWorkRepository extends JpaRepository<ModelRecentWork, Long> {

    public List<ModelRecentWork> findAllByModel(Model model);

}

