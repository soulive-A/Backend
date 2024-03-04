package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.constant.AgeType;
import com.backend.soullive_a.constant.GenderType;
import com.backend.soullive_a.dto.request.CreateProductRequest;
import com.backend.soullive_a.dto.response.ProductResponse;
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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandImageRepository brandImageRepository;
    private final ProductImageRepository productImageRepository;
    private final GenderRepository genderRepository;
    private final AgeRepository ageRepository;
    private final RangeRepository rangeRepository;

    @Override
    @Transactional
    public ProductResponse createProduct(CreateProductRequest request) {
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
        return ProductResponse.fromProduct(product, brandImages, productImages, genders, ages,
            ranges);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long productId) {
        Product product = productRepository.findById(productId)
            .orElseThrow();
        List<BrandImage> brandImages = brandImageRepository.findAllByProductId(productId);
        List<ProductImage> productImages = productImageRepository.findAllByProductId(productId);
        List<Gender> genders = genderRepository.findAllByProductId(productId);
        List<Age> ages = ageRepository.findAllByProductId(productId);
        List<Range> ranges = rangeRepository.findAllByProductId(productId);
        return ProductResponse.fromProduct(product, brandImages, productImages, genders, ages,
            ranges);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            List<BrandImage> brandImages = brandImageRepository.findAllByProductId(product.getId());
            List<ProductImage> productImages = productImageRepository.findAllByProductId(
                product.getId());
            List<Gender> genders = genderRepository.findAllByProductId(product.getId());
            List<Age> ages = ageRepository.findAllByProductId(product.getId());
            List<Range> ranges = rangeRepository.findAllByProductId(product.getId());
            productResponses.add(
                ProductResponse.fromProduct(product, brandImages, productImages, genders, ages,
                    ranges));
        }
        return productResponses;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}