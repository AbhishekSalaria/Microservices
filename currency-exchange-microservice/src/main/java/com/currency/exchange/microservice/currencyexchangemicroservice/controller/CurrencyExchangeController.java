package com.currency.exchange.microservice.currencyexchangemicroservice.controller;

import com.currency.exchange.microservice.currencyexchangemicroservice.model.CurrencyExchange;
import com.currency.exchange.microservice.currencyexchangemicroservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchangeValues(@PathVariable String from, @PathVariable String to) {
        return currencyExchangeService.getCurrencyExchangeValues(from, to);}
}
