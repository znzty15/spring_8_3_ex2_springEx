package com.javaGG.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfig_run {
	
	@Bean
	public ServerInfo serverInfo() {
		
		ServerInfo sInfo = new ServerInfo();
		sInfo.setIpNum("211.90.118.156");
		sInfo.setPortNum("80");
		
		return sInfo;		
	}
}
