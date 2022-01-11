package com.Rahimi.market;

import com.Rahimi.market.Dao.ICartItemRepository;
import com.Rahimi.market.Dao.ICartRepository;
import com.Rahimi.market.Dao.ICustomerRepository;
import com.Rahimi.market.Dao.IProductRepository;
import com.Rahimi.market.Model.Cart;
import com.Rahimi.market.Model.CartItem;
import com.Rahimi.market.Model.Customer;
import com.Rahimi.market.Model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class MarketApplication {

	private static final Logger log = LoggerFactory.getLogger(MarketApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IProductRepository iProductRepository, ICustomerRepository iCustomerRepository,
								  ICartRepository iCartRepository, ICartItemRepository iCartItemRepository) {
		return (args) -> {
			// save a new customer
			Customer customer = iCustomerRepository.save(new Customer("Hossein", "Rahimi"));
			// save a new cart
			Cart cart = iCartRepository.save(new Cart(customer));
			// save a few products
			List<Product> productList = Arrays.asList(
					new Product("Milk", 1200F),
					new Product("Cheese", 25000F),
					new Product("IceCream", 8000F),
					new Product("Popcorn", 3500F),
					new Product("Cake", 2500F),
					new Product("Oil", 16500F)
			);
			iProductRepository.saveAll(productList);
			// save a few cart items
			List<CartItem> cartItemList = Arrays.asList(
					new CartItem(cart, productList.get(0)),
					new CartItem(cart, productList.get(2)),
					new CartItem(cart, productList.get(4))
			);
			iCartItemRepository.saveAll(cartItemList);
		};
	}

}
