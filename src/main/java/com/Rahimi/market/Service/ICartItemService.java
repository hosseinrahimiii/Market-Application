package com.Rahimi.market.Service;

import com.Rahimi.market.Base.ApplicationException;
import com.Rahimi.market.Model.CartItem;

public interface ICartItemService {

    Iterable<CartItem> getAllOfCustomer();

    void deleteById(Long id) throws ApplicationException;

    void saveByProductId(Long productId) throws Exception;

    void deleteByProductId(Long productId) throws ApplicationException;

}
