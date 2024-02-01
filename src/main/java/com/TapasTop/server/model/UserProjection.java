package com.TapasTop.server.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {User.class}, name = "UserView")
public interface UserProjection {

  String getUsername();

  String getEmail();

  String getName();

  String getLastname();

  String getPicturePath();

  UserActivity getUserActivity();

  @Value("#{target.reviews.size()}")
  Integer getReviewCount();

}
