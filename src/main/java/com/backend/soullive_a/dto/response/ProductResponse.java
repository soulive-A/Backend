package com.backend.soullive_a.dto.response;

import com.backend.soullive_a.entity.*;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record ProductResponse(
        Long userId,
        Long productId,
        String company,
        String brand,
        List<BrandImageResponse> brandImages,
        String product,
        String characteristic,
        List<ProductImageResponse> productImages,
        List<GenderResponse> genders,
        List<AgeResponse> ages,
        List<RangeResponse> ranges
) {
    public static ProductResponse fromProduct(
            Product product,
            List<BrandImage> brandImage,
            List<ProductImage> productImage,
            List<Gender> genderType,
            List<Age> ageType,
            List<Range> rangeType) {
        List<BrandImageResponse> brandImages = brandImage.stream()
                .map(image -> new BrandImageResponse(image.getId(), image.getBrandImage()))
                .collect(Collectors.toList());

        List<ProductImageResponse> productImages = productImage.stream()
                .map(image -> new ProductImageResponse(image.getId(), image.getProductImage()))
                .collect(Collectors.toList());

        List<GenderResponse> genders = genderType.stream()
                .map(gender -> new GenderResponse(gender.getId(), gender.getGender()))
                .collect(Collectors.toList());

        List<AgeResponse> ages = ageType.stream()
                .map(age -> new AgeResponse(age.getId(), age.getAge()))
                .collect(Collectors.toList());

        List<RangeResponse> ranges = rangeType.stream()
                .map(range -> new RangeResponse(range.getId(), range.getRange()))
                .collect(Collectors.toList());

        return ProductResponse.builder()
                .userId(product.getUser().getId())
                .productId(product.getId())
                .company(product.getCompany())
                .brand(product.getBrand())
                .brandImages(brandImages)
                .product(product.getProduct())
                .characteristic(product.getCharacteristic())
                .productImages(productImages)
                .genders(genders)
                .ages(ages)
                .ranges(ranges)
                .build();
    }
}