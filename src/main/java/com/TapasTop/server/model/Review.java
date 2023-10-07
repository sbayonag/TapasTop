package com.TapasTop.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "dish_id"}))
public class Review {

  @NotNull
  @Size(max = 10)
  @Column(name = "rating")
  private Integer rating;

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Dish dish;

  @ManyToOne
  private User user;

}
