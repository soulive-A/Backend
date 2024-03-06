package com.backend.soullive_a.repository.model.introduction;

import com.backend.soullive_a.entity.model.Model;
import com.backend.soullive_a.entity.model.introduction.ModelIntroduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelIntroductionRepository extends JpaRepository<ModelIntroduction, Long> {
    public ModelIntroduction findByModelModelName(String name);
}

