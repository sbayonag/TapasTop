package com.TapasTop.server.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import com.TapasTop.server.model.User;
import com.TapasTop.server.model.UserActivity;

@Projection(types = {User.class}, name = "UserSmallInfo")
public interface UserSmallInfo {

  String getUsername();

  String getEmail();

  String getName();

  String getLastname();

  String getPicturePath();

  UserActivity getUserActivity();

  @Value("#{target.reviews.size()}")
  Integer getReviewCount();

}
