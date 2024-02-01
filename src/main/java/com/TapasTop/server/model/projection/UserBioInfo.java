package com.TapasTop.server.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import com.TapasTop.server.model.User;
import com.TapasTop.server.model.UserActivity;

@Projection(types = {User.class}, name = "UserBioInfo")
public interface UserBioInfo {

  String getUsername();

  String getEmail();

  String getName();

  String getLastname();

  String getPicturePath();

  String getBio();

  UserActivity getUserActivity();

  @Value("#{target.reviews.size()}")
  Integer getReviewCount();

}
