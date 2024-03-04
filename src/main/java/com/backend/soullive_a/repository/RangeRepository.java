package com.backend.soullive_a.repository;

import com.backend.soullive_a.entity.Range;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RangeRepository extends JpaRepository<Range, Long> {
    List<Range> findAllByProductId(Long productId);
    Optional<Range> findByProductId(Long productId);
}