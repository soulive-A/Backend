package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.request.CreateProductRequest;
import com.backend.soullive_a.dto.response.ProductResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "광고 상품 API", description = "광고 상품 API입니다.")
@Slf4j
@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "광고 상품 생성 API", description = "광고 상품을 생성하는 API입니다.")
    @PostMapping("")
    public BaseResponse<ProductResponse> createProduct(
            @RequestBody @Valid CreateProductRequest createProductRequest
    ) {
        return BaseResponse.<ProductResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("광고 상품을 등록했습니다.")
                .data(productService.createProduct(createProductRequest))
                .build();
    }
    @Operation(summary = "모든 광고 상품 조회 API", description = "모든 광고 상품을 조회 API입니다.")
    @GetMapping()
    public BaseResponse<List<ProductResponse>> getAllProduct() {
        return BaseResponse.<List<ProductResponse>>builder()
                .isSuccess(true)
                .code(200)
                .message("모든 광고 상품을 불러왔습니다.")
                .data(productService.getAllProduct())
                .build();
    }
    @Operation(summary = "특정 광고 상품 조회 API", description = "특정 광고 상품을 조회 API입니다.")
    @GetMapping("/{id}")
    public BaseResponse<ProductResponse> getProduct(@PathVariable Long id) {
        return BaseResponse.<ProductResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("productId = " + id + " 광고 상품을 불러왔습니다.")
                .data(productService.getProduct(id))
                .build();
    }
    @Operation(summary = "특정 광고 상품 삭제 API", description = "특정 광고 상품을 삭제 API입니다.")
    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return BaseResponse.<Void>builder()
            .isSuccess(true)
            .code(200)
            .message("광고 상품 삭제 성공")
            .build();
    }
}
