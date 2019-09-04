package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shubham Sharma
 * @date 4/9/19
 */
@Entity
@Table(name = "REVIEW")
public class Review extends MendatoryFields implements Serializable {

  @Column(name = "CONTENT")
  private String content;

  @Column(name="USERNAME")
  private String username;

  @Column(name="RATING")
  private Long rating;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "PRODUCT_ID", nullable = false)
  private Product product;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "REVIEW_ID")
  private List<Comment> comments = new ArrayList<>();

  public String getContent() {
    return content;
  }

  public void setContent( String content ) {
    this.content = content;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername( String username ) {
    this.username = username;
  }

  public Long getRating() {
    return rating;
  }

  public void setRating( Long rating ) {
    this.rating = rating;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct( Product product ) {
    this.product = product;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments( List<Comment> comments ) {
    this.comments = comments;
  }
}
