package com.udacity.course3.reviews.dbHandler;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.CommentRepository;
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
public class CommentDBHandler {

  @Autowired
  CommentRepository commentRepository;

  @Autowired
  ReviewRepository reviewRepository;

  public ResponseEntity<Comment> saveComment( Comment comment, Integer reviewId ) {
    Optional<Review> optionalReview = reviewRepository.findById(reviewId);
    if ( optionalReview.isPresent() ){
      comment.setReview(optionalReview.get());
      return ResponseEntity.status(HttpStatus.OK).body(commentRepository.save(comment));
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
  }

  public ResponseEntity<List<Comment>> getCommentsForReview( Integer reviewId ) {
    Optional<Review> optionalReview = reviewRepository.findById(reviewId);
    if(optionalReview.isPresent()){
      return ResponseEntity.status(HttpStatus.OK).body(commentRepository.findByReviewId(reviewId));
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
    }
  }
}
