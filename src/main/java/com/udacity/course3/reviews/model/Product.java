package com.udacity.course3.reviews.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "PRODUCT")
public class Product extends MendatoryFields implements Serializable {

  @Column(name = "NAME")
  private String name;

  @Column(name = "BRAND")
  private String brand;

  @Column(name = "DESCRIPTION")
  private String description;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "PRODUCT_ID")
  private List<Review> reviews = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand( String brand ) {
    this.brand = brand;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews( List<Review> reviews ) {
    this.reviews = reviews;
  }
}
