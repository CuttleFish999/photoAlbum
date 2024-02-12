package com.photoalbum.dodo.service;

import com.photoalbum.dodo.model.Product;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Product findProductById(Integer productId);

    Product updataProduct(Product product);


    Page<Product> getAllProductsPaged(Pageable pageable);
}
