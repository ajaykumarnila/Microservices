package com.infy.customerservice.apis;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.infy.customerservice.models.Customer;
import com.infy.customerservice.models.Product;
import com.infy.customerservice.models.Rating;

@RestController
@RequestMapping("/users")
public class CustomerAPI {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*@Autowired
	private WebClient.Builder webClientBuilder;*/
	
	@RequestMapping("/{userId}")
	public Customer getCustomerDetails(@PathVariable("userId") String userId) {
		Customer c1= new Customer(userId,"Ajay");
		
		List<Product> products=Arrays.asList(
				new Product("1001"),
				new Product("1002"),
				new Product("1003"),
				new Product("1004"));
		
		products=products.stream().map(product->{
			Product p=restTemplate.getForObject("http://product-service:9091/products/"+product.getProductId(), Product.class);
			Rating rating= restTemplate.getForObject("http://rating-service:9092/ratings/"+product.getProductId(), Rating.class);
			
			/*Product p= webClientBuilder.build()
					.get()
					.uri("http://localhost:9091/products/"+product.getProductId())
					.retrieve()
					.bodyToMono(Product.class).block();
			
			Rating rating=webClientBuilder.build()
					.get()
					.uri("http://localhost:9092/ratings/"+product.getProductId())
					.retrieve()
					.bodyToMono(Rating.class)
					.block();*/
			p.setRating(rating.getRating());
			return p;			
		}).collect(Collectors.toList());
		c1.setProducts(products);
		return c1;
	}
}
