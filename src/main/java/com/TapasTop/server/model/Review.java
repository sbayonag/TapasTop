package com.TapasTop.server.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "dish_id"}))
public class Review {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  @Max(10)
  private Integer rate;

  public Review(Integer rate, User user, Dish dish) {
    this.rate = rate;
    this.user = user;
    this.dish = dish;
  }

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId(User_.ID)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId(Dish_.ID)
  private Dish dish;

}
