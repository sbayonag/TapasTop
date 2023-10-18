package com.TapasTop.server.resource;

public class UserNotFoundException extends Exception {
  public UserNotFoundException(Long userId) {
    super(STR."User\{userId} was not found");
  }
}
