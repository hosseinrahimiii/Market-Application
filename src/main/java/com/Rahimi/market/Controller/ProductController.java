package com.Rahimi.market.Controller;

import com.Rahimi.market.Dao.IProductRepository;
import com.Rahimi.market.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductRepository iProductRepository;

    @GetMapping("/getAll")
    public Iterable<Product> getAllProducts() {
        return iProductRepository.findAll();
    }
}
