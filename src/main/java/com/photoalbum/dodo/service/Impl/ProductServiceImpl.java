package com.photoalbum.dodo.service.Impl;

import com.photoalbum.dodo.dao.ProductRepository;
import com.photoalbum.dodo.model.Product;
import com.photoalbum.dodo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Autowired
    private ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    @Override
    public Product findProductById(Integer productId) {

        Optional<Product> product = productRepository.findById(productId);

        return product.get();
    }

    @Override
    public Product updataProduct(Product product) {

        System.out.println(product.getProid());

        Integer productId = product.getProid();
        Optional<Product> findProduct = productRepository.findById(productId);

        System.out.println(findProduct.isPresent());

        if(findProduct.isPresent()){
//            System.out.println(product.getProimage());
            findProduct.get().setProname(product.getProname());
            findProduct.get().setProcategory(product.getProcategory());
            findProduct.get().setProimage(product.getProimage());

            findProduct.get().setProprice(product.getProprice());
            findProduct.get().setProstock(product.getProstock());
            findProduct.get().setProdescription(product.getProdescription());


            Product updataProduct = productRepository.save(findProduct.get());

            System.out.println("更新成功");
            return updataProduct;

        }else{

            Product savedProduct = productRepository.save(product);

            System.out.println("新增成功");
            return savedProduct;

        }

    }

    @Override
    public Page<Product> getAllProductsPaged(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


}
