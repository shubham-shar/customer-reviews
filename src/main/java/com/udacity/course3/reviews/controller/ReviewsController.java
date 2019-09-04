package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.dbHandler.ReviewDBHandler;
import com.udacity.course3.reviews.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    @Autowired
    ReviewDBHandler reviewDBHandler;

    /**
     * Creates a review for a product.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Review> createReviewForProduct( @PathVariable("productId") Integer productId,
                                                     @RequestBody Review review) {
        return reviewDBHandler.saveReview(review, productId);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        return reviewDBHandler.getProductReviews(productId);
    }
}