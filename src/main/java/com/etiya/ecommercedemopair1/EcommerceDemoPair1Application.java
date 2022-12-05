package com.etiya.ecommercedemopair1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication

public class EcommerceDemoPair1Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair1Application.class, args);
	}

}
