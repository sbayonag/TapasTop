package com.TapasTop.server.model;

import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {User.class}, name = "UserView")
public interface UserView {

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
}
