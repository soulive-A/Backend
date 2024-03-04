package com.backend.soullive_a.service.impl;



import com.backend.soullive_a.constant.AgeType;
import com.backend.soullive_a.constant.GenderType;
import com.backend.soullive_a.entity.Age;
import com.backend.soullive_a.entity.BrandImage;
import com.backend.soullive_a.entity.Gender;
import com.backend.soullive_a.entity.Product;
import com.backend.soullive_a.entity.ProductImage;
import com.backend.soullive_a.entity.Range;
import com.backend.soullive_a.repository.AgeRepository;
import com.backend.soullive_a.repository.BrandImageRepository;
import com.backend.soullive_a.repository.GenderRepository;
import com.backend.soullive_a.repository.ProductImageRepository;
import com.backend.soullive_a.repository.ProductRepository;
import com.backend.soullive_a.repository.RangeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    AgeRepository ageRepository;
    @Autowired
    BrandImageRepository brandImageRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    ProductImageRepository productImageRepository;
    @Autowired
    RangeRepository rangeRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void deleteProduct() {

        /*
         * given
         */
        // 광고 상품 entity 생성
        Product product = Product.builder()
            .company("큐시즘")
            .brand("소울라이브-A")
            .product("백엔드 개발")
            .characteristic("characteristic")
            .build();

        productRepository.save(product);
        // 브랜드 이미지 entity 생성
        BrandImage brandImage = BrandImage.builder()
            .product(product)
            .brandImage("브랜드 이미지 url")
            .build();
        brandImageRepository.save(brandImage);
        // 상품 이미지 entity 생성
        ProductImage productImage = ProductImage.builder()
            .product(product)
            .productImage("상품 이미지 url")
            .build();
        productImageRepository.save(productImage);
        // 성별 entity 생성
        Gender gender = Gender.builder()
            .product(product)
            .gender(GenderType.Male)
            .build();
        genderRepository.save(gender);
        // 나이 entity 생성
        Age age = Age.builder()
            .product(product)
            .age(AgeType.FIFTEEN)
            .build();
        ageRepository.save(age);
        // 범주 entity 생성
        Range range = Range.builder()
            .product(product)
            .range("범주 예시")
            .build();
        rangeRepository.save(range);


        /*
         * when
         */
        productRepository.deleteById(1L);


        /*
         * then
         */
        Assertions.assertTrue(ageRepository.findByProductId(1L).isEmpty());
        Assertions.assertTrue(brandImageRepository.findByProductId(1L).isEmpty());
        Assertions.assertTrue(genderRepository.findByProductId(1L).isEmpty());
        Assertions.assertTrue(productImageRepository.findByProductId(1L).isEmpty());
        Assertions.assertTrue(rangeRepository.findByProductId(1L).isEmpty());

    }
}