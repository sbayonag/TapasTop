package com.TapasTop.server.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @NotBlank
  @NaturalId
  @Size(max = 27)
  private String username;

  @NotBlank
  @Email
  @NaturalId
  private String email;

  @NotBlank
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
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate birthday;

  private String picturePath;

  @Transient
  UserActivity userActivity;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = Review_.USER)
  private List<Review> reviews;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public String getPicturePath() {
    return picturePath;
  }

  public void setPicturePath(String picturePath) {
    this.picturePath = picturePath;
  }

  public UserActivity getUserActivity() {
    return userActivity;
  }

  public void setUserActivity(UserActivity userActivity) {
    this.userActivity = userActivity;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  @Override
  public int hashCode() {
    return username.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof User && ((User) obj).id.equals(id);
  }

  public void addReview(Review review) {
    reviews.add(review);
  }

  @PostLoad
  private void postLoad() {
    this.userActivity = measureUserActivity();
  }

  private UserActivity measureUserActivity() {
    Long reviewsWithin30Days = reviewsWithin30Days();
    return new UserActivity(reviewsWithin30Days);
  }

  private Long reviewsWithin30Days() {
    return reviews.stream()
        .filter(
            review -> Duration.between(review.getCreatedAt(), LocalDateTime.now()).toDays() <= 30)
        .count();
  }

}
