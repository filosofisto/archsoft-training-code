package com.archsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JNIMonitorApplication {

	static {
		System.loadLibrary("stat");
	}

	public static void main(String[] args) {
		SpringApplication.run(JNIMonitorApplication.class, args);
	}
}
