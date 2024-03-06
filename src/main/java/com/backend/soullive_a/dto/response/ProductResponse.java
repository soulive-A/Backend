package com.backend.soullive_a.dto.response;

import com.backend.soullive_a.constant.AgeType;
import com.backend.soullive_a.constant.GenderType;
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
        List<String> brandImages,
        String product,
        String characteristic,
        List<String> productImages,
        List<GenderType> genders,
        List<AgeType> ages,
        List<String> ranges
) {
    public static ProductResponse fromProduct(
            Product product,
            List<BrandImage> brandImage,
            List<ProductImage> productImage,
            List<Gender> genderType,
            List<Age> ageType,
            List<Range> rangeType) {
        List<String> brandImages = brandImage.stream()
                .map(BrandImage::getBrandImage)
                .collect(Collectors.toList());

        List<String> productImages = productImage.stream()
                .map(ProductImage::getProductImage)
                .collect(Collectors.toList());

        List<GenderType> genders = genderType.stream()
                .map(Gender::getGender)
                .collect(Collectors.toList());

        List<AgeType> ages = ageType.stream()
                .map(Age::getAge)
                .collect(Collectors.toList());

        List<String> ranges = rangeType.stream()
                .map(Range::getRange)
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