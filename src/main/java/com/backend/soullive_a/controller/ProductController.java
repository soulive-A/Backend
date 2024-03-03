package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.request.CreateProductRequest;
import com.backend.soullive_a.dto.response.CreateProductResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public BaseResponse<CreateProductResponse> createProduct(
            @RequestBody @Valid CreateProductRequest createProductRequest
    ) {
        return BaseResponse.<CreateProductResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("광고 상품을 등록했습니다")
                .data(productService.createProduct(createProductRequest))
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<CreateProductResponse> getProduct(@PathVariable Long id) {
        return BaseResponse.<CreateProductResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("productId = " + id + " 광고 상품을 불러옵니다")
                .data(productService.getProduct(id))
                .build();
    }
}
