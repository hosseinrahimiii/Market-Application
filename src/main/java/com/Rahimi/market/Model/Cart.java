package com.Rahimi.market.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Customer customer;

    public Cart() {
    }

    public Cart(Customer customer) {
        this.customer = customer;
    }
}
