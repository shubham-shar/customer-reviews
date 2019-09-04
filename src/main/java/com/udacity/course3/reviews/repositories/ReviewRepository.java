package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Shubham Sharma
 * @date 4/9/19
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {
  List<Review> findByProductId( Integer productId );

  Review findByContentAndUsername( String awesome, String username );
}
