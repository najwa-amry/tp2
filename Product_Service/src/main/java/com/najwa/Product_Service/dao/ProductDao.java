package com.najwa.Product_Service.dao;

import com.najwa.Product_Service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    // You can define custom query methods here if necessary
}

