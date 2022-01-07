package com.Rahimi.market.Dao;


import com.Rahimi.market.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {

}
