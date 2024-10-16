package com.najwa.Product_Service.controller;

import com.najwa.Product_Service.dto.request.ProductRequest;
import com.najwa.Product_Service.dto.response.ProductResponse;
import com.najwa.Product_Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint pour ajouter un produit
    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.addProduct(productRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer tous les produits
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    // Endpoint pour récupérer un produit par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) {
        ProductResponse response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
}
