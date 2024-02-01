package com.TapasTop.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {

  @Transient
  UserActivity userActivity = new UserActivity();

  @Transient
  Integer reviewCount;

  @Id
  @GeneratedValue
  private Long id;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @NotBlank
  @NotNull
  @Size(max = 27)
  @NaturalId
  private String username;

  @Email
  @Column(unique = true)
  @NotNull
  private String email;

  @NotBlank
  @NotNull
  private String password;

  @NotBlank
  @Size(max = 27)
  private String name;

  @NotBlank
  @Size(max = 27)
  private String lastname;

  @Size(max = 280)
  private String bio;

  @Past
  private LocalDate birthday;

  private String picturePath;

  @OneToMany(mappedBy = Review_.USER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Review> reviews;

  @Override
  public int hashCode() {
    return username.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof User && ((User) obj).id.equals(id);
  }

  @PostLoad
  private void postLoad() {
    userActivity.setUserActivityEnumByReviewCount(reviews);
    this.reviewCount = reviews.size();
  }

}
