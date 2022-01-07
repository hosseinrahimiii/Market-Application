package com.Rahimi.market.Dao;


import com.Rahimi.market.Model.Cart;
import com.Rahimi.market.Model.CartItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findByCart(Cart cart);

}
