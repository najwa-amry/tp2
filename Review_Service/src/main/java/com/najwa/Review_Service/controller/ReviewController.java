package com.najwa.Review_Service.controller;

import com.najwa.Review_Service.dto.request.ReviewRequest;
import com.najwa.Review_Service.dto.response.ReviewResponse;
import com.najwa.Review_Service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Endpoint pour ajouter un nouvel avis
    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@RequestBody ReviewRequest request) {
        ReviewResponse response = reviewService.addReview(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer tous les avis
    @GetMapping
    public List<ReviewResponse> getAllReviews() {
        return reviewService.getAllReviews();
    }

   // Endpoint pour récupérer les avis d'un produit par son ID
   @GetMapping("/product/{productId}")
   public List<ReviewResponse> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }
}
