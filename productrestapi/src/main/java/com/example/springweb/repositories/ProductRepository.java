package com.example.springweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springweb.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
