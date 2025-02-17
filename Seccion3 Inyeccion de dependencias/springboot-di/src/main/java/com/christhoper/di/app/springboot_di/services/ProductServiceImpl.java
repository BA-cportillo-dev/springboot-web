package com.christhoper.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.christhoper.di.app.springboot_di.models.Product;
import com.christhoper.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private Environment environment;

    @Autowired
    @Qualifier("ProductRepositoryJson")
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            //Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
            
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
            
            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
