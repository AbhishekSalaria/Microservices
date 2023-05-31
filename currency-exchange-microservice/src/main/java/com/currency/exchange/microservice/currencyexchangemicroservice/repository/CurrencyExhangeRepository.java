package com.currency.exchange.microservice.currencyexchangemicroservice.repository;

import com.currency.exchange.microservice.currencyexchangemicroservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExhangeRepository extends JpaRepository<CurrencyExchange,Integer> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
