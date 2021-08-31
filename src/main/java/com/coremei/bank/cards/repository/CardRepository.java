package com.coremei.bank.cards.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coremei.bank.cards.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

	List<Card> findByCustomerId(int customerId);
}
