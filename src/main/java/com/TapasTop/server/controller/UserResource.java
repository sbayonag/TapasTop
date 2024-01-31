package com.TapasTop.server.controller;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@BasePathAwareController("/users")
public class UserResource {

  @GetMapping(path = "/hola")
  public @ResponseBody ResponseEntity<?> getTest() {
    return ResponseEntity.ok("Hola, mundo!");
  }
}
