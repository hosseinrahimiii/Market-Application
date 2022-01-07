package com.Rahimi.market.Dao;


import com.Rahimi.market.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

}
