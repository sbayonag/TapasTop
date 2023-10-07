package com.TapasTop.server.model;

import java.util.Date;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")})
@Data
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @CreationTimestamp
  private Date createdAt;

  @NotBlank
  @Size(max = 27)
  private String username;

  @NotBlank
  @Email
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
  @DateTimeFormat
  private Date birthday;

  private String picturePath;

  @OneToMany(mappedBy = "user")
  private List<Review> reviews;

}
