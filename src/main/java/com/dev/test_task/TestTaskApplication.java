package com.dev.test_task;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTaskApplication {

	public static void main(String[] args) {
		DOMConfigurator.configure("src/main/resources/log4j.xml");
		SpringApplication.run(TestTaskApplication.class, args);
	}

}
