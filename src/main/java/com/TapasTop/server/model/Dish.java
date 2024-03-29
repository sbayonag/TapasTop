package com.TapasTop.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Dish {

  @Id
  @GeneratedValue
  private Long id;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @NotBlank
  String name;

  @NotBlank
  @Size(max = 280)
  String description;

  @OneToMany(mappedBy = Review_.DISH, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Review> reviews;

}
