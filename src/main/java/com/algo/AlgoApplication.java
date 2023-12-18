package com.algo;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EntityScan("com.algo")
@ComponentScan("com.algo")
@SpringBootApplication
public class AlgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgoApplication.class, args);
	}

}
