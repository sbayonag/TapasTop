package com.TapasTop.server.repository;

import com.TapasTop.server.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryIntegrationTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void countUsersTest() {
    List<User> users = userRepository.findAll();
    assertEquals(5, users.size(), "The number of users differ from the json file");
  }
}
