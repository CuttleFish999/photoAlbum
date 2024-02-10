package com.photoalbum.dodo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //  SpringJPA
    @PostMapping("/InsertProducts")
    public Integer insertProduct(@RequestBody Product product) {

        productRepository.save(product);
        return product.getProid();
    }

    @GetMapping("/Products")
    public String insertProduct(Model model) {
        System.out.println("qq");
        List<Product> productList = new ArrayList<>();
//        System.out.println(productList.get(0).getProid());
        productRepository.findAll().forEach(productList::add);
        model.addAttribute("products", productList);

        return "index";
    }

//    @GetMapping("/test")
//    @ResponseBody
//    public String test23() {
//        System.out.println("qq");
//        return "Hello, this is a test."; // 这将直接返回字符串，而不是视图名称
//    }

}

