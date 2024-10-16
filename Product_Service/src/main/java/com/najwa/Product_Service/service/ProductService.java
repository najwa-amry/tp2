package com.najwa.Product_Service.service;

import com.najwa.Product_Service.dao.ProductDao;
import com.najwa.Product_Service.dto.request.ProductRequest;
import com.najwa.Product_Service.dto.response.ProductResponse;
import com.najwa.Product_Service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    // Méthode pour récupérer un produit par ID
    public ProductResponse getProductById(long id) {
        Product product = productDao.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found with id: " + id));

        // Construire la réponse à partir de l'entité Product
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .weight(product.getWeight())
                .build();
    }

    // Méthode pour ajouter un nouveau produit
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setWeight(productRequest.getWeight());

        Product savedProduct = productDao.save(product);

        // Construire la réponse à partir du produit sauvegardé
        return ProductResponse.builder()
                .productId(savedProduct.getProductId())
                .name(savedProduct.getName())
                .weight(savedProduct.getWeight())
                .build();
    }

    // Méthode pour récupérer tous les produits
    public List<ProductResponse> getAllProducts() {
        return productDao.findAll().stream()
                .map(product -> ProductResponse.builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .weight(product.getWeight())
                        .build())
                .collect(Collectors.toList());
    }
}

