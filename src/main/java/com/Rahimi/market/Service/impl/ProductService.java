package com.Rahimi.market.Service.impl;

import com.Rahimi.market.Dao.IProductRepository;
import com.Rahimi.market.Model.Product;
import com.Rahimi.market.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public Iterable<Product> getAll() {
        return iProductRepository.findAll();
    }

}
