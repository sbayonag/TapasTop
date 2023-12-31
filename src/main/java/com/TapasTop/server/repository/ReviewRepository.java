package com.TapasTop.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import com.TapasTop.server.model.Review;

@RepositoryRestResource()
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true",
    methods = RequestMethod.GET)
public interface ReviewRepository extends JpaRepository<Review, Long> {

  @Override
  @RestResource(exported = false)
  default <S extends Review> S save(S entity) {
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

}
