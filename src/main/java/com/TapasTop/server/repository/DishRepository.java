package com.TapasTop.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TapasTop.server.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

}
