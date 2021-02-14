package com.test.HelloWorldSpringBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloWorldSpringBootApplication {


	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
	}

	@RestController
	public static class GreetingController {

		@Value("${example.property}")
		private String test;

		@GetMapping(value = "/greet")
		public String greet(){
			System.out.println("this is testing property from application properties file "+test);
			return test;
		}

		@GetMapping(value="/testing123")
		public String testing(){
			System.out.println("this is testing method");
			return "testing from master";
		}

		@GetMapping(value="/anotherTest")
		public String anotherTest(){
			return "this is for testing purpose";
		}

		@PostMapping(value="/addstudent")
		public String studentName(@RequestBody Student student){
			return student.getName() +" adding sharma";

		}
	}
}
