package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.constant.GenderType;
import com.backend.soullive_a.dto.response.model.issue.ModelIssueResponse;
import com.backend.soullive_a.dto.response.model.issue.ModelNewsResponse;
import com.backend.soullive_a.entity.model.issue.ModelIssue;
import com.backend.soullive_a.entity.model.issue.ModelNews;
import com.backend.soullive_a.entity.model.popularity.ModelPopularGender;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import com.backend.soullive_a.repository.model.issue.ModelIssueRepository;
import com.backend.soullive_a.repository.model.issue.ModelNewsRepository;
import com.backend.soullive_a.service.ModelIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelIssueImpl implements ModelIssueService {

    private final ModelIssueRepository modelIssueRepository;
    private final ModelNewsRepository modelNewsRepository;

    /**
     * 부정이슈 조회 서비스로직
     * @param modelName
     * @return
     */
    @Override
    public ModelIssueResponse getIssue(String modelName) {
        ModelIssue modelIssue = modelIssueRepository.findByModelModelName(modelName)
                .orElseThrow(() -> new NotFoundUserException());

        List<ModelNews> modelNewsList = modelNewsRepository.findAllByModelIssueModelModelName(modelName);

        List<ModelNewsResponse> modelNewsResponse = new ArrayList<>();

        for (ModelNews modelNews : modelNewsList) {
            modelNewsResponse.add(
                    ModelNewsResponse.builder()
                            .company(modelNews.getCompany())
                            .newsDate(modelNews.getNewsDate())
                            .title(modelNews.getTitle())
                            .newsUrl(modelNews.getNewsUrl())
                            .build()
            );
        }

       return ModelIssueResponse.builder()
                .scoreUrl(modelIssue.getScoreUrl())
                .aiComment(modelIssue.getAiComment())
                .crime(modelIssue.getCrime())
                .modelNewsResponseList(modelNewsResponse)
                .build();
    }
}
