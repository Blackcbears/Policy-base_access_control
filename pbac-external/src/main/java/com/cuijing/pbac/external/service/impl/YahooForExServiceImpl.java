package com.cuijing.pbac.external.service.impl;

import com.cuijing.pbac.external.service.YahooForExService;
import com.cuijing.pbac.types.Currency;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
/**
 * @author CuiJIng
 * @date 2021-5-13 14:04
 */
@Component
public class YahooForExServiceImpl implements YahooForExService {

    @Override
    public BigDecimal getExchangeRate(Currency sourceCurrency, Currency targetCurrency) {
        return BigDecimal.ONE;
    }
}
