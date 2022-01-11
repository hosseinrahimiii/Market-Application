package com.Rahimi.market.Controller;

import com.Rahimi.market.Model.Product;
import com.Rahimi.market.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/getAll")
    public Iterable<Product> getAll() {
        return iProductService.getAll();
    }
}
