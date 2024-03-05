package com.backend.soullive_a.repository;

import com.backend.soullive_a.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
    List<Gender> findAllByProductId(Long productId);
}