package com.najwa.Recommendation_Service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecommendationResponse {
    private Long recommendationId;
    private Long productId;
    private String author;
    private int rate;
    private String content;
}
