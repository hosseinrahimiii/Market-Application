package com.Rahimi.market.Dao;


import com.Rahimi.market.Model.Cart;
import com.Rahimi.market.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends CrudRepository<Cart, Long> {

    Cart findByCustomer(Customer customer);

}
