package com.christhoper.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.christhoper.di.app.springboot_di.models.Product;

public class ProductRepositoryImpl implements ProductRepository{

    List<Product> data;

	public ProductRepositoryImpl() {
        this.data = Arrays.asList(
          new Product(1L, "Memoria corsair 32", 300L),
          new Product(2L, "Cpu Intel Core i9", 850L),  
          new Product(3L, "Teclado Razer Mini 60%", 180L),  
          new Product(4L, "Motherboard Gygabyte%", 490L)  
        );
	}

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
