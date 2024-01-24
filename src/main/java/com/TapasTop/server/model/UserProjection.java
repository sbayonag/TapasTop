package com.TapasTop.server.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(types = {User.class}, name = "UserView")
public interface UserProjection {

  String getUsername();

  String getEmail();

  Date getCreatedAt();

  String getName();

  String getLastname();

  String getBio();

  Date birthday();

  String getPicturePath();

  UserActivity getUserActivity();

  Integer getReviewCount();

  List<Review> getReviews();

}
