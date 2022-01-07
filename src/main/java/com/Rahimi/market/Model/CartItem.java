package com.Rahimi.market.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;

    private Integer count;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product) {
        this.product = product;
        this.cart = cart;
        this.count = 1;
    }
}
