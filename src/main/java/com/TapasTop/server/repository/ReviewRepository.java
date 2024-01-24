package com.TapasTop.server.repository;

import com.TapasTop.server.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestResource()
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true",
    methods = RequestMethod.GET)
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
