package com.currencyconversionmicroservice.currencyconversionmicroservice.proxy;

import com.currencyconversionmicroservice.currencyconversionmicroservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getCurrencyExchangeValues(@PathVariable String from, @PathVariable String to);

}
