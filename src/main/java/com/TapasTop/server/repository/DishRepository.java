package com.TapasTop.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.TapasTop.server.model.Dish;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
public interface DishRepository extends JpaRepository<Dish, Long> {

}
