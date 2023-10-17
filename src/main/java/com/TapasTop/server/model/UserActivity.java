package com.TapasTop.server.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserActivity {

  public static final Long UPPER_LIMIT_VERY_ACTIVE = 8L;
  public static final Long UPPER_LIMIT_ACTIVE = 4L;
  public static final Long UPPER_LIMIT_LOW = 1L;
  public static final Long ACTIVITY_PERIOD_IN_DAYS = 30L;

  public enum UserActivityEnum {
    INACTIVE, ACTIVE, VERY_ACTIVE, TAPEADOR;
  }

  @JsonValue
  UserActivityEnum activityEnum;

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

  public UserActivity() {
    this.activityEnum = UserActivityEnum.INACTIVE;
  }

  private Long reviewCountWithinPeriod(List<Review> reviews) {
    return reviews.stream().filter(review -> Duration
        .between(review.getCreatedAt(), LocalDateTime.now()).toDays() <= ACTIVITY_PERIOD_IN_DAYS)
        .count();
  }

}
