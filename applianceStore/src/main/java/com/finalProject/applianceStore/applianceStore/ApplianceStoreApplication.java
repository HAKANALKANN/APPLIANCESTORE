package com.finalProject.applianceStore.applianceStore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplianceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplianceStoreApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){return new ModelMapper(); }

}
