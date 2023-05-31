package com.currencyconversionmicroservice.currencyconversionmicroservice.controller;

import com.currencyconversionmicroservice.currencyconversionmicroservice.model.CurrencyConversion;
import com.currencyconversionmicroservice.currencyconversionmicroservice.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyConversionService currencyConversionService;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {

        return currencyConversionService.currencyConversion(from, to, quantity);
    }
}
