package com.backend.soullive_a.repository.model.issue;

import com.backend.soullive_a.entity.model.issue.ModelIssue;
import com.backend.soullive_a.entity.model.issue.ModelNews;
import com.backend.soullive_a.entity.model.popularity.ModelPopularGender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelNewsRepository extends JpaRepository<ModelNews, Long> {
    List<ModelNews> findAllByModelIssueModelModelName(String modelName);
}
