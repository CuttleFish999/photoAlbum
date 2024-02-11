package com.photoalbum.dodo.controller;

import com.photoalbum.dodo.model.Product;
import com.photoalbum.dodo.service.Impl.ProductServiceImpl;
import com.photoalbum.dodo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Products")
public class ProductController {

//    private final ProductServiceImpl productService;

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> productList = productServiceImpl.getAllProduct();
        Map<Integer, String> imageMap = new HashMap<>(); // 创建一个新的Map来存储图片数据，假设每个产品都有一个唯一的ID

        for (Product product : productList) {
            byte[] imageBytes = product.getProimage(); // 假设这是从数据库获取的图片二进制数据
            if (imageBytes != null) {
                String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
                imageMap.put(product.getProid(), imageBase64);
            }
        }
        model.addAttribute("products", productList);
        model.addAttribute("images", imageMap);
        return "index";
    }


    @PostMapping("/insertProducts")
    @ResponseBody
    public Integer insertProduct(@RequestBody Product product) {
        Product savedProduct = productServiceImpl.saveProduct(product);
        return savedProduct.getProid();
    }
}
