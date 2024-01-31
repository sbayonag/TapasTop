package com.TapasTop.server.exception;

public class UserNotFoundException extends Exception {
  public UserNotFoundException(Long userId) {
    super(STR."User\{userId} was not found");
  }
}
