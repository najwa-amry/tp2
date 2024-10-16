package com.najwa.Recommendation_Service.controller;

import com.najwa.Recommendation_Service.dto.request.RecommendationRequest;
import com.najwa.Recommendation_Service.dto.response.RecommendationResponse;
import com.najwa.Recommendation_Service.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<RecommendationResponse> addRecommendation(@RequestBody RecommendationRequest request) {
        RecommendationResponse response = recommendationService.addRecommendation(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<RecommendationResponse> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    @GetMapping("/product/{productId}")
    public List<RecommendationResponse> getRecommendationsByProductId(@PathVariable Long productId) {
        return recommendationService.getRecommendationsByProductId(productId);
    }
}

