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
        Model model = modelRepository.findByModelName(modelName)
                .orElseThrow(() -> new NotFoundUserException());
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
        String aiComment="ai 한줄 평 준비 중 입니다.";
        String scoreUrl="https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_modelFitness_score.png";

        if (productModel.getModel().getId() == 1) {
            aiComment = "김희애의 우아하고 고급스러운 이미지와 함께 가족적인 이미지가 어우러져 lg 시그니처 브랜드의 프리미엄적인 이미지와 고품질 제품에 잘 어울릴 것이라고 판단 됩니다.";
            scoreUrl="https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_modelFitness_score.png";
        }
        else if (productModel.getModel().getId() == 2) {
            aiComment = "한지민은 깨끗하고 바른 이미지로 LG시그니처와 어울리지만 현재 목표하는 프리미엄 이미지를 강조하기에는 다소 아쉬운 모델입니다.";
            scoreUrl="https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/hanjimin_modelFitness_score.png";
        } else if (productModel.getModel().getId() == 3) {
            aiComment = "김고은은 세련되고 사랑스러운 이미지로 LG 시그니처가 목표로 하는 세련되고 대중에게 친숙한 이미지와 적합합니다.";
            scoreUrl="https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_modelFitness_score.png";
        }

    
        modelFitnessRepository.save(
                ModelFitness.builder()
                        .productModel(productModel)
                        .aiComment(aiComment)
                        .scoreUrl(scoreUrl)
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
