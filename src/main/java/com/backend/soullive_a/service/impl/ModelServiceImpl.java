package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.dto.response.ModelRecommendResponse;
import com.backend.soullive_a.dto.response.ModelResponse;
import com.backend.soullive_a.dto.response.RecentModelResponse;
import com.backend.soullive_a.entity.Product;
import com.backend.soullive_a.entity.model.Model;
import com.backend.soullive_a.entity.model.ProductModel;
import com.backend.soullive_a.entity.model.fitness.ModelFitness;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import com.backend.soullive_a.repository.ModelRepository;
import com.backend.soullive_a.repository.ProductModelRepository;
import com.backend.soullive_a.repository.ProductRepository;
import com.backend.soullive_a.repository.model.fitness.ModelFitnessRepository;
import com.backend.soullive_a.service.ModelService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ProductRepository productRepository;
    private final ProductModelRepository productModelRepository;
    private final ModelFitnessRepository modelFitnessRepository;

    @Override
    @Transactional
    public ModelResponse getModel(String modelName,Long productId) {
        System.out.println(modelName);
        Model model = modelRepository.findByModelName(modelName)
                .orElseThrow(() -> new NotFoundUserException("실페ㅐ"));
        System.out.println(model.getModelName()+productId);
        //최근 조회 모델 데이터 업데이트
        updateRecentViewModel(model,productId);

        return ModelResponse.builder()
                .modelId(model.getId())

                .imageUrl(model.getImageUrl())
                .modelName(model.getModelName())
                .birth(model.getBirth())
                .age(model.getAge())

                .job(model.getJob())
                .info(model.getInfo())
                .agency(model.getAgency())
                .aiRate(model.getAiRate())
                .build();
    }

    private void createModelFitness( ProductModel productModel) {

        modelFitnessRepository.save(
                ModelFitness.builder()
                        .productModel(productModel)
                        .aiComment("ai comment입니다")
                        .scoreUrl("점수 url입니다")
                        .build()
        );


    }


    /**
     * 최근 조회한 모델들 조회
     */
    @Override
    @Transactional
    public List<RecentModelResponse> getRecentModel(Long productId) {
        return productModelRepository.getRecentModels(productId);
    }

    @Override
    @Transactional
    public List<ModelRecommendResponse> getRecommendModel(){

        return modelRepository.findAllRecommendModel();
    }
    /**
     * 광고 상품 엔티티 생성
     * @param model
     * @param productId
     */
    private void updateRecentViewModel(Model model, Long productId){

        Product product = productRepository.findById(productId)
            .orElseThrow(NotFoundUserException::new);

        ProductModel productModel = productModelRepository.save(
                ProductModel.builder()
                        .model(model)
                        .product(product)
                        .searchTime(LocalDateTime.now())
                        .build()
        );

        //모델 적합도 더미데이터 생성
        createModelFitness(productModel);
    }
}
