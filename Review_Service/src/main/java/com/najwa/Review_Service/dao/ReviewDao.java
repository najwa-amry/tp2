package com.najwa.Review_Service.dao;

import com.najwa.Review_Service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {

    // Méthode pour récupérer les avis d'un produit par son ID
    List<Review> findByProductId(Long productId);
}
