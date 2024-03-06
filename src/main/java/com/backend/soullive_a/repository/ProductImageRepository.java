package com.backend.soullive_a.repository;

import com.backend.soullive_a.entity.ProductImage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findAllByProductId(Long productId);
    Optional<ProductImage> findByProductId(Long productId);
}