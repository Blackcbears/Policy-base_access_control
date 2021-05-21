package com.cuijing.pbac.external.service.impl;

import com.cuijing.pbac.types.Currency;
import com.cuijing.pbac.types.ExchangeRate;
import com.cuijing.pbac.external.ExchangeRateService;
import com.cuijing.pbac.external.service.YahooForExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
/**
 * @author CuiJIng
 * @date 2021-5-13 14:04
 */
@Component
public class ExchangeRateServiceImpl implements ExchangeRateService {
    @Autowired
    private YahooForExService yahooForexService;

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        }
        BigDecimal foreignExchange = yahooForexService.getExchangeRate(source, target);
        return new ExchangeRate(foreignExchange, source, target);
    }
}