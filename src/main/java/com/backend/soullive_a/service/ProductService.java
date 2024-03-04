package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.request.CreateProductRequest;
import com.backend.soullive_a.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);

    ProductResponse getProduct(Long id);

    List<ProductResponse> getAllProduct();
}
