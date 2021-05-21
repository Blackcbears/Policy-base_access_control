package com.cuijing.pbac.external;

import com.cuijing.pbac.types.Currency;
import com.cuijing.pbac.types.ExchangeRate;

/**
 * @author CuiJIng
 * @date 2021-5-13 10:04
 */
public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Currency source, Currency target);
}
