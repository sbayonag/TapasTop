package com.TapasTop.server.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserActivity {

  public static final Long UPPER_LIMIT_VERY_ACTIVE = 8L;
  public static final Long UPPER_LIMIT_ACTIVE = 4L;
  public static final Long UPPER_LIMIT_LOW = 2L;

  public enum UserActivityEnum {
    LOW, ACTIVE, VERY_ACTIVE, TAPEADOR;
  }

  @JsonValue
  UserActivityEnum activityEnum;

  public UserActivity(List<Review> reviews) {
    Long activity = reviewsWithin30Days(reviews);
    if (activity < UPPER_LIMIT_LOW)
      this.activityEnum = UserActivityEnum.LOW;
    else if (activity < UPPER_LIMIT_ACTIVE)
      this.activityEnum = UserActivityEnum.ACTIVE;
    else if (activity < UPPER_LIMIT_VERY_ACTIVE)
      this.activityEnum = UserActivityEnum.VERY_ACTIVE;
    else
      this.activityEnum = UserActivityEnum.TAPEADOR;
  }

  private Long reviewsWithin30Days(List<Review> reviews) {
    return reviews.stream()
        .filter(
            review -> Duration.between(review.getCreatedAt(), LocalDateTime.now()).toDays() <= 30)
        .count();
  }
}
