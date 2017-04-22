package myapp.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class Main 
extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure (
			SpringApplicationBuilder builder) {
		
		return builder.sources(Main.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
