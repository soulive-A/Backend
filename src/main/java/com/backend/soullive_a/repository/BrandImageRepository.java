package com.backend.soullive_a.repository;

import com.backend.soullive_a.entity.BrandImage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandImageRepository extends JpaRepository<BrandImage, Long> {
    List<BrandImage> findAllByProductId(Long productId);
    Optional<BrandImage> findByProductId(Long productId);
}
