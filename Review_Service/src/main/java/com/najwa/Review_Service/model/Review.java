package com.najwa.Review_Service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;     // Review ID
    private Long productId;    // Product ID
    private String author;     // Author of the review
    private String subject;    // Subject of the review
    private String content;    // Content of the review

    public Review(Long productId, String author, String subject, String content) {
        this.productId = productId;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

}
