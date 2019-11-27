package com.infy.productinfoservice.apis;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.productinfoservice.models.Product;

@RestController
@RequestMapping("/products")
public class ProductAPI {

	@RequestMapping("/{productId}")
	public Product getProduct(@PathVariable("productId") String productId) {
		return new Product(productId,"Mobile");
	}
}
