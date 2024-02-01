package com.TapasTop.server.repository;

import com.TapasTop.server.model.Dish;
import com.TapasTop.server.model.DishProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = DishProjection.class)
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
public interface DishRepository extends JpaRepository<Dish, Long> {

}
