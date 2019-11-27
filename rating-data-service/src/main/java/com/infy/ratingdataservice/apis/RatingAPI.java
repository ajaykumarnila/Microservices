package com.infy.ratingdataservice.apis;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ratingdataservice.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingAPI {
	@RequestMapping("/{productId}")
	public Rating getRatings(@PathVariable("productId") String productId) {
		return new Rating(productId,4);
	}

}
