package com.photoalbum.dodo.service;

import com.photoalbum.dodo.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Product findProductById(Integer productId);

    Product updataProduct(Product product);
}
