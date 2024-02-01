package com.TapasTop.server.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class UserActivity {

  public static final Long UPPER_LIMIT_VERY_ACTIVE = 8L;
  public static final Long UPPER_LIMIT_ACTIVE = 4L;
  public static final Long UPPER_LIMIT_LOW = 1L;
  public static final Long ACTIVITY_PERIOD_IN_DAYS = 30L;

  @JsonValue
  UserActivityEnum activityEnum;

  public UserActivity(List<Review> reviews) {
    this.activityEnum = getUserActivityEnumByReviews(reviews);
  }

  public UserActivityEnum getUserActivityEnumByReviews(List<Review> reviews) {
    Long activity = reviewCountWithinPeriod(reviews);
    if (activity < UPPER_LIMIT_LOW)
      return UserActivityEnum.INACTIVE;
    else if (activity < UPPER_LIMIT_ACTIVE)
      return UserActivityEnum.ACTIVE;
    else if (activity < UPPER_LIMIT_VERY_ACTIVE)
      return UserActivityEnum.VERY_ACTIVE;
    else
      return UserActivityEnum.TAPEADOR;
  }

  private Long reviewCountWithinPeriod(List<Review> reviews) {
    return reviews.stream().filter(review -> Duration
        .between(review.getCreatedAt(), LocalDateTime.now()).toDays() <= ACTIVITY_PERIOD_IN_DAYS)
        .count();
  }

  public enum UserActivityEnum {
    INACTIVE, ACTIVE, VERY_ACTIVE, TAPEADOR
  }

}
