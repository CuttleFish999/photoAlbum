package com.photoalbum.dodo.controller;

import com.photoalbum.dodo.model.Product;
import com.photoalbum.dodo.service.Impl.ProductServiceImpl;
import com.photoalbum.dodo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

//  單筆新增&修改
    @PostMapping("/insert/{productId}")
    @ResponseBody
    public Integer insertProduct(@RequestBody Product product) {

        Integer updateId =  productServiceImpl.updataProduct(product).getProid();

        return updateId;
    }

    @GetMapping("")
    public String listProducts(Model model,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> productPage = productServiceImpl.getAllProductsPaged(pageRequest);
        Map<Integer, String> imageMap = new HashMap<>();

        for (Product product : productPage.getContent()) {
            byte[] imageBytes = product.getProimage();
            if (imageBytes != null) {
                String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
                imageMap.put(product.getProid(), imageBase64);
            }
        }

        model.addAttribute("products", productPage);
        model.addAttribute("images", imageMap);
        return "backStage/indexProducts";
    }


}
