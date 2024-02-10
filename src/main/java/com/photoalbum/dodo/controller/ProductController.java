package com.photoalbum.dodo.controller;

import com.photoalbum.dodo.model.Product;
import com.photoalbum.dodo.service.Impl.ProductServiceImpl;
import com.photoalbum.dodo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Products")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = (ProductServiceImpl) productService;
    }

    @GetMapping("")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "index";
    }

    @PostMapping("/insertProducts")
    @ResponseBody
    public Integer insertProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return savedProduct.getProid();
    }
}
