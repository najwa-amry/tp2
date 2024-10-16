package com.najwa.Recommendation_Service.service;

import com.najwa.Recommendation_Service.dao.RecommendationDao;
import com.najwa.Recommendation_Service.dto.request.RecommendationRequest;
import com.najwa.Recommendation_Service.dto.response.RecommendationResponse;
import com.najwa.Recommendation_Service.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationDao recommendationDao;

    // Ajouter une nouvelle recommandation
    public RecommendationResponse addRecommendation(RecommendationRequest request) {
        Recommendation recommendation = new Recommendation(
                request.getProductId(),
                request.getAuthor(),
                request.getRate(),
                request.getContent()
        );

        Recommendation savedRecommendation = recommendationDao.save(recommendation);

        return RecommendationResponse.builder()
                .recommendationId(savedRecommendation.getRecommendationId())
                .productId(savedRecommendation.getProductId())
                .author(savedRecommendation.getAuthor())
                .rate(savedRecommendation.getRate())
                .content(savedRecommendation.getContent())
                .build();
    }

    // Récupérer toutes les recommandations
    public List<RecommendationResponse> getAllRecommendations() {
        return recommendationDao.findAll().stream()
                .map(rec -> RecommendationResponse.builder()
                        .recommendationId(rec.getRecommendationId())
                        .productId(rec.getProductId())
                        .author(rec.getAuthor())
                        .rate(rec.getRate())
                        .content(rec.getContent())
                        .build())
                .collect(Collectors.toList());
    }

    // Récupérer les recommandations par ID de produit
    public List<RecommendationResponse> getRecommendationsByProductId(Long productId) {
        return recommendationDao.findByProductId(productId).stream()
                .map(rec -> RecommendationResponse.builder()
                        .recommendationId(rec.getRecommendationId())
                        .productId(rec.getProductId())
                        .author(rec.getAuthor())
                        .rate(rec.getRate())
                        .content(rec.getContent())
                        .build())
                .collect(Collectors.toList());
    }
}
