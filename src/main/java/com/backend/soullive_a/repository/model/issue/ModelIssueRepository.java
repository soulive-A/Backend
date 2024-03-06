package com.backend.soullive_a.repository.model.issue;

import com.backend.soullive_a.entity.model.issue.ModelIssue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelIssueRepository extends JpaRepository<ModelIssue, Long> {
    public Optional<ModelIssue> findByModelModelName(String modelName);
}
