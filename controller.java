package com.example.currencyconverterapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterController {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.78);
        exchangeRates.put("BRL", 5.12);
        exchangeRates.put("JPY", 157.23);
        exchangeRates.put("AUD", 1.51);
        exchangeRates.put("CAD", 1.36);
    }

    @GetMapping("/convert")
    public Map<String, Object> convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {

        from = from.toUpperCase();
        to = to.toUpperCase();

        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Invalid currency code. Supported currencies: " + exchangeRates.keySet());
            return error;
        }

        double amountInUSD = amount / exchangeRates.get(from);
        double convertedAmount = amountInUSD * exchangeRates.get(to);

        Map<String, Object> result = new HashMap<>();
        result.put("from", from);
        result.put("to", to);
        result.put("original_amount", amount);
        result.put("converted_amount", String.format("%.2f", convertedAmount));
        result.put("rate_from_USD", exchangeRates.get(to));

        return result;
    }
}
