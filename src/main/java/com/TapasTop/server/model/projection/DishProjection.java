package com.TapasTop.server.model.projection;

import com.TapasTop.server.model.Dish;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Dish.class}, name = "DishView")
public interface DishProjection {
    
    String getName();
}
