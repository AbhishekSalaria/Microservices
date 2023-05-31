package com.currency.exchange.microservice.currencyexchangemicroservice.service;

import com.currency.exchange.microservice.currencyexchangemicroservice.model.CurrencyExchange;
import com.currency.exchange.microservice.currencyexchangemicroservice.repository.CurrencyExhangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    CurrencyExhangeRepository repository;

    @Autowired
    private Environment environment;
    public CurrencyExchange getCurrencyExchangeValues(String from, String to) {


        CurrencyExchange byFromAndTo = repository.findByFromAndTo(from, to);

        if(byFromAndTo == null) {
            return new CurrencyExchange(-1,from,to,-1,"-1");
        }

        String port = environment.getProperty("local.server.port");
        byFromAndTo.setEnvironment(port);

        return byFromAndTo;
    }
}
