package com.photoalbum.dodo.dao;

import com.photoalbum.dodo.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product,Integer> {

}
