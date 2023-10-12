package com.TapasTop.server.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TapasTop.server.model.Dish;
import com.TapasTop.server.model.Review;
import com.TapasTop.server.model.User;

@SpringBootTest
public class UserRepositoryIntegrationTest {

  Logger logger = LoggerFactory.getLogger(UserRepositoryIntegrationTest.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DishRepository dishRepository;

  @Autowired
  private ReviewRepository reviewRepository;

  @Test
  public void countUsersTest() {
    List<User> users = userRepository.findAll();
    List<Dish> dishes = dishRepository.findAll();
    assertEquals(5, users.size(), "The number of users differ from the json file");
    assertEquals(6, dishes.size(), "The number of dishes differ from the json file");
    for (int i = 0; i < users.size(); i++) {
      Dish dish = dishes.get(i);
      User user = users.get(i);
      Review review = new Review(10, user, dish);
      user.addReview(review);
      dish.addReview(review);
      // reviewRepository.save(review);
    }
    List<Review> reviews = reviewRepository.findAll();
    assertEquals(users.size(), reviews.size(), "The number of reviews differ from the json file");
  }
}
