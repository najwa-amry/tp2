package com.najwa.Review_Service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {
    private Long reviewId;
    private Long productId;
    private String author;
    private String subject;
    private String content;
}
