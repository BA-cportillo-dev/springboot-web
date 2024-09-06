package com.christhoper.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.christhoper.di.app.springboot_di.models.Product;
import com.christhoper.di.app.springboot_di.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice()*1.25d;
            //Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
