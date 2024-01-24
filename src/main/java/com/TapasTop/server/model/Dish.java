package com.TapasTop.server.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Dish {

  @Id
  @GeneratedValue
  private Long id;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = Review_.DISH)
  private List<Review> reviews;

  public void addReview(Review review) {
    reviews.add(review);
  }

}
