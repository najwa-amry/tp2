package com.najwa.Recommendation_Service.dto.request;

import lombok.Data;

@Data
public class RecommendationRequest {
    private Long productId;
    private String author;
    private int rate;
    private String content;
}
