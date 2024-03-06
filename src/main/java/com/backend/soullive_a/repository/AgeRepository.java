package com.backend.soullive_a.repository;

import com.backend.soullive_a.entity.Age;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgeRepository extends JpaRepository<Age, Long> {
    List<Age> findAllByProductId(Long productId);
    Optional<Age> findByProductId(Long productId);
}