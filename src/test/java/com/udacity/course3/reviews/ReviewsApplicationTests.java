package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.CommentRepository;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	CommentRepository commentRepository;

	@Test
	public void contextLoads() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(productRepository).isNotNull();
		assertThat(reviewRepository).isNotNull();
		assertThat(commentRepository).isNotNull();
	}

	@Test
	public void testProduct(){
		Product product = new Product();
		product.setName("Xbox");
		product.setDescription("gaming console");
		product.setBrand("Microsoft");
		product.setReviews(Collections.emptyList());
		productRepository.save(product);

		assertThat(productRepository.findByNameAndBrand("Xbox", "Microsoft")).isNotNull();
		assertThat(productRepository.findByNameAndBrand("Xbox", "Microsoft").getDescription())
				.isEqualTo("gaming console");
	}

	@Test
	public void testReview(){
		Product product = productRepository.findByNameAndBrand("PS4", "SONY");
		Review review = new Review();
		review.setContent("fantastic");
		review.setRating(new Long(5));
		review.setUsername("User");
		review.setProduct(product);
		reviewRepository.save(review);
		assertThat(reviewRepository.findByProductId(product.getId())).isNotEmpty();
	}

	@Test
	public void testComment(){
		Review review = reviewRepository.findByContentAndUsername("Awesome", "shubham");
		Comment comment = new Comment();
		comment.setContent("something");
		comment.setUsername("shubham");
		comment.setReview(review);
		commentRepository.save(comment);
		assertThat(commentRepository.findByContentAndUsername("something", "shubham").getContent())
				.isEqualTo("something");
	}

}