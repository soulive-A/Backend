package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.constant.AgeType;
import com.backend.soullive_a.constant.GenderType;
import com.backend.soullive_a.dto.request.CreateProductRequest;
import com.backend.soullive_a.dto.response.CreateProductResponse;
import com.backend.soullive_a.entity.*;
import com.backend.soullive_a.repository.*;
import com.backend.soullive_a.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandImageRepository brandImageRepository;
    private final ProductImageRepository productImageRepository;
    private final GenderRepository genderRepository;
    private final AgeRepository ageRepository;
    private final RangeRepository rangeRepository;

    @Override
    @Transactional
    public CreateProductResponse createProduct(CreateProductRequest request){
        log.info("productservice 들어옴");
        Product product = Product.builder()
                .company(request.company())
                .brand(request.brand())
                .product(request.product())
                .characteristic(request.characteristic())
                .build();
        productRepository.save(product);

        List<BrandImage> brandImages = new ArrayList<>();
        for (String image : request.brandImage()) {
            BrandImage brandImage = BrandImage.builder()
                    .product(product)
                    .brandImage(image)
                    .build();
            brandImages.add(brandImage);
            brandImageRepository.save(brandImage);
        }

        List<ProductImage> productImages = new ArrayList<>();
        for (String image : request.productImage()) {
            ProductImage productImage = ProductImage.builder()
                    .product(product)
                    .productImage(image)
                    .build();
            productImages.add(productImage);
            productImageRepository.save(productImage);
        }

        List<Gender> genders = new ArrayList<>();
        for (GenderType genderType : request.gender()) {
            Gender gender = Gender.builder()
                    .product(product)
                    .gender(genderType)
                    .build();
            genders.add(gender);
            genderRepository.save(gender);
        }

        List<Age> ages = new ArrayList<>();
        for (AgeType ageType : request.age()) {
            Age age = Age.builder()
                    .product(product)
                    .age(ageType)
                    .build();
            ages.add(age);
            ageRepository.save(age);
        }

        List<Range> ranges = new ArrayList<>();
        for (String rangeType : request.range()) {
            Range range = Range.builder()
                    .product(product)
                    .range(rangeType)
                    .build();
            ranges.add(range);
            rangeRepository.save(range);
        }
        return CreateProductResponse.fromProduct(product, brandImages, productImages, genders, ages, ranges);
    }

    @Override
    @Transactional
    public CreateProductResponse getProduct(Long productId) {
        Product product=productRepository.findById(productId)
                .orElseThrow();
        List<BrandImage> brandImages = brandImageRepository.findAllByProductId(productId);
        List<ProductImage> productImages = productImageRepository.findAllByProductId(productId);
        List<Gender> genders = genderRepository.findAllByProductId(productId);
        List<Age> ages = ageRepository.findAllByProductId(productId);
        List<Range> ranges=rangeRepository.findAllByProductId(productId);
        return CreateProductResponse.fromProduct(product, brandImages, productImages, genders, ages, ranges);
    }
}
