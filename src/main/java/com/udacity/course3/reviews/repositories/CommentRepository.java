package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Shubham Sharma
 * @date 4/9/19
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
  List<Comment> findByReviewId( Integer reviewId );

  Comment findByContentAndUsername( String content, String username );
}
