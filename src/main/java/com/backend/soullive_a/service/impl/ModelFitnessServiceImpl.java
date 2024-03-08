package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.dto.request.ModelFitnessRequest;
import com.backend.soullive_a.dto.response.model.fitness.ModelFitnessResponse;
import com.backend.soullive_a.entity.BrandImage;
import com.backend.soullive_a.entity.Product;
import com.backend.soullive_a.entity.ProductImage;
import com.backend.soullive_a.entity.model.Model;
import com.backend.soullive_a.entity.model.ProductModel;
import com.backend.soullive_a.entity.model.fitness.ModelFitness;
import com.backend.soullive_a.entity.model.introduction.ModelImageKeyword;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import com.backend.soullive_a.repository.*;
import com.backend.soullive_a.repository.model.fitness.ModelFitnessRepository;
import com.backend.soullive_a.repository.model.introduction.ModelImageKeywordRepository;
import com.backend.soullive_a.service.ModelFitnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelFitnessServiceImpl implements ModelFitnessService {

    private final ModelFitnessRepository modelFitnessRepository;
    private final ModelRepository modelRepository;
    private final ProductRepository productRepository;
    private final ProductModelRepository productModelRepository;
    private final ModelImageKeywordRepository modelImageKeywordRepository;
    private final BrandImageRepository brandImageRepository;
    private final ProductImageRepository productImageRepository;

    @Override
    public ModelFitnessResponse getModelFitness(ModelFitnessRequest request) {
        Model model = modelRepository.findByModelName(request.modelName())
                .orElseThrow(() -> new NotFoundUserException("해당 Model을 찾을 수 없습니다"));

        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new NotFoundUserException("해당 Product를 찾을 수 없습니다")); //커스텀에러

        ProductModel productModel = productModelRepository.findTopByProductAndModelOrderByIdDesc(product, model);


        ModelFitness modelFitness =  modelFitnessRepository.findById(productModel.getId())
                .orElseThrow(() -> new NotFoundUserException("모델적합도를 찾을수없습니다")); //커스텀에러

        List<ModelImageKeyword> modelImageKeywords = modelImageKeywordRepository.findAllByModel(model);
        List<String> modelImageKeywordResponses = modelImageKeywords.stream()
                .map(ModelImageKeyword::getKeyword)
                .collect(Collectors.toList());

        List<BrandImage> brandImages = brandImageRepository.findAllByProductId(product.getId());
        List<String> brandImageResponses = brandImages.stream()
                .map(BrandImage::getBrandImage)
                .collect(Collectors.toList());

        List<ProductImage> productImages = productImageRepository.findAllByProductId(product.getId());
        List<String> productImageResponses = productImages.stream()
                .map(ProductImage::getProductImage)
                .collect(Collectors.toList());

        return ModelFitnessResponse.builder()
                .scoreUrl(modelFitness.getScoreUrl())
                .aiComment(modelFitness.getAiComment())
                .modelImageKeywordList(modelImageKeywordResponses)
                .brandImageKeywordList(brandImageResponses)
                .productImageKeywordList(productImageResponses)
                .build();
    }
}
