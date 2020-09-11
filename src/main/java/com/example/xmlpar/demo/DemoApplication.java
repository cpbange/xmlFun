package com.example.xmlpar.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running Spring Boot Application");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = null;
		try {
			User u1 = new User("John","Bange", 34,"male",0);
			User u2 = new User("Ron","Banged", 35,"male",1);
			xml = xmlMapper.writeValueAsString(u2);
			xmlMapper.writeValue(new File("simple_bean.xml"), u1);
			//File file = new File("simple_bean.xml");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(xml);

	}

}
