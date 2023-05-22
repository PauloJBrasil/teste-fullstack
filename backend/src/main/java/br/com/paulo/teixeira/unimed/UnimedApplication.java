package br.com.paulo.teixeira.unimed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class UnimedApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnimedApplication.class, args);
	}

}
