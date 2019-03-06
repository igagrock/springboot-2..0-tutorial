package com.initgrep.springit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate =  false)
public class AuditorConfig {
  
  
  @Bean
  public AuditorAware<String> auditorAware(){
    return new AuditorAwareImpl();
  }
  

}
