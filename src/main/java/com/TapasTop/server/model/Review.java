package com.TapasTop.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "dish_id"}))
public class Review {

  @Id
  @GeneratedValue
  Long id;

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

  @ManyToOne
  @MapsId(User_.ID)
  private User user;

  @ManyToOne
  @MapsId(Dish_.ID)
  private Dish dish;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getRate() {
    return rate;
  }

  public void setRate(Integer rate) {
    this.rate = rate;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Dish getDish() {
    return dish;
  }

  public void setDish(Dish dish) {
    this.dish = dish;
  }

}
