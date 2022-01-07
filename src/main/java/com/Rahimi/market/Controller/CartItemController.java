package com.Rahimi.market.Controller;

import com.Rahimi.market.Dao.ICartItemRepository;
import com.Rahimi.market.Dao.ICartRepository;
import com.Rahimi.market.Dao.ICustomerRepository;
import com.Rahimi.market.Dao.IProductRepository;
import com.Rahimi.market.Model.Cart;
import com.Rahimi.market.Model.CartItem;
import com.Rahimi.market.Model.Customer;
import com.Rahimi.market.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Autowired
    ICartRepository iCartRepository;
    @Autowired
    ICartItemRepository iCartItemRepository;

    @GetMapping("/getAllOfCustomer")
    public Iterable<CartItem> getAllOfCustomer() {
        //mock => get current user(customer) id from his/her session => 1
        Long customerId = 1L;
        Customer customer  = iCustomerRepository.findById(customerId).orElse(null);
        Cart cart = iCartRepository.findByCustomer(customer);
        if (cart == null){
            cart = iCartRepository.save(new Cart(customer));
        }
        return iCartItemRepository.findByCart(cart);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam(value = "id") Long id){
        iCartItemRepository.deleteById(id);
    }

    @PostMapping("/saveByProductId")
    public Boolean saveProduct(@RequestParam(value = "productId") Long productId){
        //mock => get current user(customer) id from his/her session => 1
        Long customerId = 1L;
        Customer customer  = iCustomerRepository.findById(customerId).orElse(null);
        Cart cart = iCartRepository.findByCustomer(customer);
        if (cart == null){
            cart = iCartRepository.save(new Cart(customer));
        }
        Product product = iProductRepository.findById(productId).orElse(null);
        if (product == null){
            System.out.println("No product found with this id");
            return false;
        }
        List<CartItem> cartItems = iCartItemRepository.findByCart(cart);
        CartItem cartItem = cartItems.stream().filter(c -> c.getProduct().getId() == productId).findFirst().orElse(null);
        if (cartItem != null){
            cartItem.setCount(cartItem.getCount() + 1);
            iCartItemRepository.save(cartItem);
        } else {
            iCartItemRepository.save(new CartItem(cart, product));
        }
        return true;
    }

    @PostMapping("/deleteByProductId")
    public Boolean deleteProduct(@RequestParam(value = "productId") Long productId){
        //mock => get current user(customer) id from his/her session => 1
        Long customerId = 1L;
        Customer customer  = iCustomerRepository.findById(customerId).orElse(null);
        Cart cart = iCartRepository.findByCustomer(customer);
        if (cart == null){
            cart = iCartRepository.save(new Cart(customer));
        }
        Product product = iProductRepository.findById(productId).orElse(null);
        if (product == null){
            System.out.println("No product found with this id");
            return false;
        }
        List<CartItem> cartItems = iCartItemRepository.findByCart(cart);
        CartItem cartItem = cartItems.stream().filter(c -> c.getProduct().getId() == productId).findFirst().orElse(null);
        if (cartItem == null){
            System.out.println("No product found with this id in your cart");
            return false;
        }
        iCartItemRepository.delete(cartItem);
        return true;
    }
}
