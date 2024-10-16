package com.najwa.Recommendation_Service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;  // ID de la recommandation
    private Long productId;  // ID du produit
    private String author;   // Auteur de la recommandation
    private int rate;        // Note de la recommandation (ex. 1 à 5)
    private String content;  // Contenu de la recommandation





    // Constructeur avec paramètres
    public Recommendation(Long productId, String author, int rate, String content) {
        this.productId = productId;
        this.author = author;
        this.rate = rate;
        this.content = content;
    }
}
