package com.javaGG.ex;

import java.io.ObjectInputFilter.Config;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String config = null;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.equals("dev")) {
			config = "dev";
		}else if(str.equals("run")) {
			config = "run";
		}
		sc.close();
		
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().addActiveProfile(config);
		//ctx.load("applicationCTX_dev.xml","applicationCTX_run.xml");
		ctx.register(ApplicationConfig_dev.class, ApplicationConfig_run.class);
		ctx.refresh();
		
		ServerInfo sInfo = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP : " + sInfo.getIpNum());
		System.out.println("Port : " + sInfo.getPortNum());
		
		ctx.close();
	}

}
