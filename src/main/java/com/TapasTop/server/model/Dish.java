package com.TapasTop.server.model;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

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
