package com.christhoper.curso.app.springboot_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christhoper.curso.app.springboot_crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
