package com.initgrep.springit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="dash")
public class DashProperties {
	
	/** Default welcome message **/
	private String welcomeMessage ="Hello World";

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	
	
}
