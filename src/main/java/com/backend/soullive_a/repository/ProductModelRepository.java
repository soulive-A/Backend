package com.backend.soullive_a.repository;

import com.backend.soullive_a.dto.response.RecentModelResponse;
import com.backend.soullive_a.entity.model.ProductModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {

    @Query("Select "
        + "new com.backend.soullive_a.dto.response.RecentModelResponse(m.id,m.imageUrl,m.modelName,m.aiRate) "
        + "From ProductModel p "
        + "Inner Join Model m On p.model.id = m.id "
        + "Where p.product.id = :productId "
        + "ORDER BY p.searchTime DESC")
    List<RecentModelResponse> getRecentModels(@Param("productId") Long productId);
}
