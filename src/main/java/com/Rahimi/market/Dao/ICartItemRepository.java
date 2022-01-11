package com.Rahimi.market.Dao;


import com.Rahimi.market.Model.Cart;
import com.Rahimi.market.Model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findByCart(Cart cart);

}
