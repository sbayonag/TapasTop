package com.TapasTop.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.TapasTop.server.model.User;
import com.TapasTop.server.model.UserView;

@RepositoryRestResource(excerptProjection = UserView.class)
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
public interface UserRepository extends JpaRepository<User, Long> {

}
