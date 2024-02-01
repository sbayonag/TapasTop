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

  public UserActivity() {
    this.activityEnum = UserActivityEnum.INACTIVE;
  }

  public void setUserActivityEnumByReviewCount(List<Review> reviews) {
    Long activity = reviewCountWithinPeriod(reviews);
    if (activity < UPPER_LIMIT_LOW)
      this.activityEnum = UserActivityEnum.INACTIVE;
    else if (activity < UPPER_LIMIT_ACTIVE)
      this.activityEnum = UserActivityEnum.ACTIVE;
    else if (activity < UPPER_LIMIT_VERY_ACTIVE)
      this.activityEnum = UserActivityEnum.VERY_ACTIVE;
    else
      this.activityEnum = UserActivityEnum.TAPEADOR;
  }

  private Long reviewCountWithinPeriod(List<Review> reviews) {
    return reviews.stream().filter(
        review -> Duration.between(review.getCreatedAt(), LocalDateTime.now())
            .toDays() <= ACTIVITY_PERIOD_IN_DAYS).count();
  }

  public enum UserActivityEnum {
    INACTIVE, ACTIVE, VERY_ACTIVE, TAPEADOR
  }

}
