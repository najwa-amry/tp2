package com.najwa.Review_Service.dto.request;

import lombok.Data;

@Data
public class ReviewRequest {
    private Long productId;    // Product ID
    private String author;     // Author of the review
    private String subject;    // Subject of the review
    private String content;    // Content of the review

}
