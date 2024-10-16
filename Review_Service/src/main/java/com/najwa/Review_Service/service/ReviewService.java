package com.najwa.Review_Service.service;

import com.najwa.Review_Service.dao.ReviewDao;
import com.najwa.Review_Service.dto.request.ReviewRequest;
import com.najwa.Review_Service.dto.response.ReviewResponse;
import com.najwa.Review_Service.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements ReviewServiceImpl {

    @Autowired
    private ReviewDao reviewDao;

    // Ajouter un nouvel avis

    public ReviewResponse addReview(ReviewRequest request) {
        Review review = new Review(
                request.getProductId(),
                request.getAuthor(),
                request.getSubject(),
                request.getContent()
        );

        Review savedReview = reviewDao.save(review);

        return ReviewResponse.builder()
                .reviewId(savedReview.getReviewId())
                .productId(savedReview.getProductId())
                .author(savedReview.getAuthor())
                .subject(savedReview.getSubject())
                .content(savedReview.getContent())
                .build();
    }

    // Récupérer tous les avis
    public List<ReviewResponse> getAllReviews() {
        return reviewDao.findAll().stream()
                .map(review -> ReviewResponse.builder()
                        .reviewId(review.getReviewId())
                        .productId(review.getProductId())
                        .author(review.getAuthor())
                        .subject(review.getSubject())
                        .content(review.getContent())
                        .build())
                .collect(Collectors.toList());
    }

    // Récupérer les avis d'un produit par son ID
    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        return reviewDao.findByProductId(productId).stream()
                .map(review -> ReviewResponse.builder()
                        .reviewId(review.getReviewId())
                        .productId(review.getProductId())
                        .author(review.getAuthor())
                        .subject(review.getSubject())
                        .content(review.getContent())
                        .build())
                .collect(Collectors.toList());
    }
}
