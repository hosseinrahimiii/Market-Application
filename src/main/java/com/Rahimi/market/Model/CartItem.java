package com.Rahimi.market.Model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    private Integer count;

    public CartItem(Cart cart, Product product) {
        this.product = product;
        this.cart = cart;
        this.count = 1;
    }
}
