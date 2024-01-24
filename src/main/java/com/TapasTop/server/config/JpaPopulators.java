package com.TapasTop.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class JpaPopulators {

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator(ObjectMapper objectMapper)
      throws Exception {
    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
    factory.setResources(new Resource[] {new ClassPathResource("01-user-data.json"),
        new ClassPathResource("02-dish-data.json")});
    factory.setMapper(objectMapper);
    return factory;
  }
}
