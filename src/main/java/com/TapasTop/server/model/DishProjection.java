package com.TapasTop.server.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Dish.class}, name = "DishView")
public interface DishProjection {
    
    String getName();
}
