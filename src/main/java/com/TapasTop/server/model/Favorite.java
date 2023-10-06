package com.TapasTop.server.model;


import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "dish_id"})})
public class Favorite {

  @EmbeddedId
  private FavoriteId id;
  
  @CreationTimestamp
  private Date createdAt;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  @MapsId("user_id")
  User user;

  @ManyToOne(optional = false)
  @JoinColumn(name = "dish_id", nullable = false, updatable = false)
  @MapsId("dish_id")
  Dish dish;

}
