package com.udacity.course3.reviews.dbHandler;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Shubham Sharma
 * @date 4/9/19
 */
@Component
public class ProductDBHandler {

  @Autowired
  ProductRepository productRepository;

  public Product saveProduct( Product product ) {
    return productRepository.save(product);
  }

  public ResponseEntity<Product> getProduct( Integer id ) {
    Optional<Product> optionalProduct = productRepository.findById(id);
    return optionalProduct.map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }
}
