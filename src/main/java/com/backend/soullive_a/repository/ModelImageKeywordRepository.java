package com.backend.soullive_a.repository;

import com.backend.soullive_a.dto.response.ModelImageKeywordResponse;
import com.backend.soullive_a.entity.model.introduction.ModelImageKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelImageKeywordRepository extends JpaRepository<ModelImageKeyword, Long> {
    public List<ModelImageKeyword> findAllById(Long modelId);
}

