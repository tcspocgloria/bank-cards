package com.coremei.bank.cards.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coremei.bank.cards.model.Properties;
import com.coremei.bank.cards.config.CardServiceConfig;
import com.coremei.bank.cards.model.Card;
import com.coremei.bank.cards.model.Customer;
import com.coremei.bank.cards.repository.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class CardController {
	
	private static Logger logger = LoggerFactory.getLogger(CardController.class);

	@Autowired
	private CardRepository repository;

	@Autowired
	private CardServiceConfig config;

	@PostMapping("/myCards")
	public List<Card> getCardDetails(@RequestBody Customer customer) {
		logger.info("getCardDetails() method started");
		
		List<Card> cards = repository.findByCustomerId(customer.getCustomerId());
		
		logger.info("getCardDetails() ended started");
		return cards;
	}

	@GetMapping("/cards/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(config.getMsg(), config.getBuildVersion(), config.getMailDetails(),
				config.getActiveBranches());
		return ow.writeValueAsString(properties);
	}

}
