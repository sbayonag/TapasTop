package com.TapasTop.server.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class FavoriteId implements Serializable {
  @Column(name = "user_id")
  Long userId;
  @Column(name = "dish_id")
  Long dishId;
}
