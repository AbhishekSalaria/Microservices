package com.currencyconversionmicroservice.currencyconversionmicroservice.service;

import com.currencyconversionmicroservice.currencyconversionmicroservice.model.CurrencyConversion;
import com.currencyconversionmicroservice.currencyconversionmicroservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversion currencyConversion(String from, String to, int quantity) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchangeValues(from,to);

        return new CurrencyConversion(currencyConversion.getId(), from, to,
                                      currencyConversion.getConversionMultiple(),quantity,
                                      currencyConversion.getConversionMultiple() * quantity,
                                      currencyConversion.getEnvironment());
    }
}
