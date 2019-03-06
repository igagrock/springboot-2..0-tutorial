package com.initgrep.springit.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class DatabaseLoader_O2 implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public void run(String... args) throws Exception {
		
		log.info("Database Loader O2 ...");
		
	
	}

}
