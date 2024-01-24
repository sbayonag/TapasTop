package com.TapasTop.server.resource;

import com.TapasTop.server.model.Dish;
import com.TapasTop.server.model.Review;
import com.TapasTop.server.model.User;
import com.TapasTop.server.repository.DishRepository;
import com.TapasTop.server.repository.ReviewRepository;
import com.TapasTop.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@BasePathAwareController("/reviews")
public class ReviewResource {

  @Autowired
  private static ReviewRepository reviewRepository;

  @Autowired
  private static UserRepository userRepository;

  @Autowired
  private static DishRepository dishRepository;

  @PostMapping
  ResponseEntity<?> createReview(@RequestBody ReviewForm reviewForm)
      throws UserNotFoundException, DishNotFoundException {
    User user = userRepository.findById(reviewForm.userId())
        .orElseThrow(() -> new UserNotFoundException(reviewForm.userId()));
    Dish dish = dishRepository.findById(reviewForm.dishId())
        .orElseThrow(() -> new DishNotFoundException(reviewForm.dishId()));
    Review review = new Review(reviewForm.rate(), user, dish);
    review = reviewRepository.save(review);
    user.addReview(review);
    dish.addReview(review);
    EntityModel<Review> resource = EntityModel.of(review);
    return ResponseEntity.ok(resource);
  }
}
