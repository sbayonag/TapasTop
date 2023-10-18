package com.TapasTop.server.resource;

public class DishNotFoundException extends Exception {

  public DishNotFoundException(long dishId) {
    super(STR."Dish with id \{dishId} was not found");
  }
}
