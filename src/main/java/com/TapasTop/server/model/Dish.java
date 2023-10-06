package com.TapasTop.server.model;

import java.util.Date;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dish {

  @Id
  @GeneratedValue
  private Long id;

  @CreationTimestamp
  private Date createdAt;

  @OneToMany(mappedBy = "dish")
  private List<Favorite> favorites;

}
