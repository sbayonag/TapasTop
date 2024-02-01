package com.TapasTop.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "dish_id"}))
@Entity
public class Review {

  @Id
  @GeneratedValue
  Long id;

  @NotNull
  @Max(10)
  @Min(0)
  private int rate;

  @Size(max = 280)
  private String comment;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dish_id")
  private Dish dish;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public Review(Integer rate, String comment, User user, Dish dish) {
    this.rate = rate;
    this.comment = comment;
    this.user = user;
    this.dish = dish;
  }

}
