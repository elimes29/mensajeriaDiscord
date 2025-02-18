package com.alura.mesajeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication
@EnableScheduling
public class MesajeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MesajeriaApplication.class, args);
	}

}
