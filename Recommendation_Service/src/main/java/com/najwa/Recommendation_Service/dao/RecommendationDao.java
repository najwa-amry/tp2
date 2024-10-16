package com.najwa.Recommendation_Service.dao;

import com.najwa.Recommendation_Service.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationDao extends JpaRepository<Recommendation, Long> {
    // Méthode pour récupérer les recommandations par ID de produit
    List<Recommendation> findByProductId(Long productId);
}
