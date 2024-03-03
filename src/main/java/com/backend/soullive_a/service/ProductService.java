package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.request.CreateProductRequest;
import com.backend.soullive_a.dto.response.CreateProductResponse;

public interface ProductService {
    CreateProductResponse createProduct(CreateProductRequest request);
    CreateProductResponse getProduct(Long id);
}
