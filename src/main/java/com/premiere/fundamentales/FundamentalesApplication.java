package com.premiere.fundamentales;

import entity.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import repository.ApplicationRepository;

@SpringBootApplication
public class FundamentalesApplication {

	private static final Logger log = LoggerFactory.getLogger(FundamentalesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FundamentalesApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner demo (ApplicationRepository repository){
//		return (args) -> {
//			repository.save(new Application("moez", "moez.abid", "aaaaa"));
//			repository.save(new Application("issam", "issam.issam", "bbbb"));
//			repository.save(new Application("khalil", "khalil.issam", "aaacccccaa"));
//			for (Application application : repository.findAll()) {
//				log.info("the application is :" + application.toString());
//			}
//
//		};
//	}
}
