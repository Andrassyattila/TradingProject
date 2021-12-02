package com.codecool.tradingproject.service;

import com.codecool.tradingproject.model.Product;
import com.codecool.tradingproject.repository.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation{


    ProductsRepository productsRepository;

    public void updateProduct(Long id, String image) {
        Product product = productsRepository.getById(id);
        product.setImage(image);
        productsRepository.save(product);
    }



}
