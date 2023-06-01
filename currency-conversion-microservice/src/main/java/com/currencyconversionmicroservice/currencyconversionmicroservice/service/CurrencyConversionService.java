package com.currencyconversionmicroservice.currencyconversionmicroservice.service;

import com.currencyconversionmicroservice.currencyconversionmicroservice.model.CurrencyConversion;
import com.currencyconversionmicroservice.currencyconversionmicroservice.proxy.CurrencyExchangeProxy;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    @CircuitBreaker(name= "currencyConversionFallback",fallbackMethod = "currencyConversionFallback")
    @Bulkhead(name= "currencyConversionFallback")
    public CurrencyConversion currencyConversion(String from, String to, int quantity) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchangeValues(from,to);

        return new CurrencyConversion(currencyConversion.getId(), from, to,
                                      currencyConversion.getConversionMultiple(),quantity,
                                      currencyConversion.getConversionMultiple() * quantity,
                                      currencyConversion.getEnvironment());
    }

    public CurrencyConversion currencyConversionFallback(Exception ex) {
        return new CurrencyConversion(-1,"-1","-1",-1,-1,-1,"-1");
    }
}
