package com.udacity.course3.reviews.dbHandler;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Shubham Sharma
 * @date 4/9/19
 */
@Component
public class ReviewDBHandler {

  @Autowired
  ReviewRepository reviewRepository;

  @Autowired
  ProductRepository productRepository;

  public ResponseEntity<Review> saveReview( Review review, Integer productId ) {
    Optional<Product> optionalProduct = productRepository.findById(productId);
    if(optionalProduct.isPresent()) {
      review.setProduct(optionalProduct.get());
      return ResponseEntity.status(HttpStatus.CREATED).body(reviewRepository.save(review));
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  public ResponseEntity<List<Review>> getProductReviews( Integer productId ) {
    Optional<Product> optionalProduct = productRepository.findById(productId);
    if(optionalProduct.isPresent()){
      return ResponseEntity.status(HttpStatus.OK).body(reviewRepository.findByProductId(productId));
    } else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
    }
  }
}
