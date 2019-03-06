package com.initgrep.springit.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class ThymeLeadSecurityDialectConfig {
  // TODO * Configuring this bean should not be needed once Spring Boot's Thymeleaf starter includes
  // configuration
  // TODO for thymeleaf-extras-springsecurity5 (instead of thymeleaf-extras-springsecurity4)
  @Bean
  public SpringSecurityDialect securityDialect() {
    return new SpringSecurityDialect();
  }
}
