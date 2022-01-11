package com.Rahimi.market.Service.impl;

import com.Rahimi.market.Base.ApplicationException;
import com.Rahimi.market.Dao.ICartItemRepository;
import com.Rahimi.market.Dao.ICartRepository;
import com.Rahimi.market.Dao.ICustomerRepository;
import com.Rahimi.market.Dao.IProductRepository;
import com.Rahimi.market.Model.Cart;
import com.Rahimi.market.Model.CartItem;
import com.Rahimi.market.Model.Customer;
import com.Rahimi.market.Model.Product;
import com.Rahimi.market.Service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService implements ICartItemService {

    @Autowired
    ICustomerRepository iCustomerRepository;
    @Autowired
    ICartRepository iCartRepository;
    @Autowired
    ICartItemRepository iCartItemRepository;
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public Iterable<CartItem> getAllOfCustomer() {
        //mock => current customer's id from session => 1
        Long customerId = 1L;
        Customer customer  = iCustomerRepository.findById(customerId).orElse(null);
        Cart cart = iCartRepository.findByCustomer(customer);
        if (cart == null){
            cart = iCartRepository.save(new Cart(customer));
        }
        return iCartItemRepository.findByCart(cart);
    }

    @Override
    public void deleteById(Long id) throws ApplicationException {
        if (!iCartItemRepository.existsById(id))
            throw new ApplicationException("No item found with this id in your cart");
        iCartItemRepository.deleteById(id);
    }

    @Override
    public void saveByProductId(Long productId) throws ApplicationException {
        //mock => current customer's id from session => 1
        Long customerId = 1L;
        Customer customer  = iCustomerRepository.findById(customerId).orElse(null);
        Cart cart = iCartRepository.findByCustomer(customer);
        if (cart == null){
            cart = iCartRepository.save(new Cart(customer));
        }
        Product product = iProductRepository.findById(productId).orElse(null);
        if (product == null){
            throw new ApplicationException("No product found with this id");
        }
        List<CartItem> cartItems = iCartItemRepository.findByCart(cart);
        CartItem cartItem = cartItems.stream().filter(c -> c.getProduct().getId() == productId).findFirst().orElse(null);
        if (cartItem != null){
            cartItem.setCount(cartItem.getCount() + 1);
            iCartItemRepository.save(cartItem);
        } else {
            iCartItemRepository.save(new CartItem(cart, product));
        }
    }

    @Override
    public void deleteByProductId(Long productId) throws ApplicationException {
        //mock => current customer's id from session => 1
        Long customerId = 1L;
        Customer customer  = iCustomerRepository.findById(customerId).orElse(null);
        Cart cart = iCartRepository.findByCustomer(customer);
        if (cart == null){
            cart = iCartRepository.save(new Cart(customer));
        }
        Product product = iProductRepository.findById(productId).orElse(null);
        if (product == null){
            throw new ApplicationException("No product found with this id");
        }
        List<CartItem> cartItems = iCartItemRepository.findByCart(cart);
        CartItem cartItem = cartItems.stream().filter(c -> c.getProduct().getId() == productId).findFirst().orElse(null);
        if (cartItem == null){
            throw new ApplicationException("No product found with this id in your cart");
        }
        iCartItemRepository.delete(cartItem);
    }

}
