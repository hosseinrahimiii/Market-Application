package com.Rahimi.market.Controller;

import com.Rahimi.market.Base.ApplicationException;
import com.Rahimi.market.Model.CartItem;
import com.Rahimi.market.Service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    ICartItemService iCartItemService;

    @GetMapping("/getAllOfCustomer")
    public Iterable<CartItem> getAllOfCustomer() {
        return iCartItemService.getAllOfCustomer();
    }

    @PostMapping("/saveByProductId/{productId}")
    public void saveByProductId(@PathVariable Long productId) throws Exception {
        iCartItemService.saveByProductId(productId);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) throws ApplicationException {
        iCartItemService.deleteById(id);
    }

    @DeleteMapping("/deleteByProductId/{productId}")
    public void deleteByProductId(@PathVariable Long productId) throws ApplicationException {
        iCartItemService.deleteByProductId(productId);
    }
}
