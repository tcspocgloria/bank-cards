package com.coremei.bank.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class MicroserviceBankCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBankCardsApplication.class, args);
	}

}
