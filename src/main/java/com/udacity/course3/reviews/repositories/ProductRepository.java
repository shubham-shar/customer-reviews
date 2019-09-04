package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shubham Sharma
 * @date 4/9/19
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
  Product findByNameAndBrand( String name, String brand );
}
