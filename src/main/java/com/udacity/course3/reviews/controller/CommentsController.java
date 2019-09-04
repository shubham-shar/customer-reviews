package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.dbHandler.CommentDBHandler;
import com.udacity.course3.reviews.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/Comment")
public class CommentsController {

    @Autowired
    CommentDBHandler commentDBHandler;

    /**
     * Creates a comment for a review.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<Comment> createCommentForReview( @PathVariable("reviewId") Integer reviewId,
                                                           @RequestBody Comment comment) {
        return commentDBHandler.saveComment(comment, reviewId);
    }

    /**
     * List Comment for a review.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        return commentDBHandler.getCommentsForReview(reviewId);
    }
}