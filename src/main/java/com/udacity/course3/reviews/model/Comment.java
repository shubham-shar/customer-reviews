package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Shubham Sharma
 * @date 4/9/19
 */
@Entity
@Table(name = "COMMENT")
public class Comment extends MendatoryFields implements Serializable {

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "USERNAME")
  private String username;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "REVIEW_ID", nullable = false)
  private Review review;

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

  public Review getReview() {
    return review;
  }

  public void setReview( Review review ) {
    this.review = review;
  }
}
