package com.cuijing.pbac.domain.service;

import com.cuijing.pbac.domain.entity.Account;
import com.cuijing.pbac.types.ExchangeRate;
import com.cuijing.pbac.types.Money;
/**
 * @author CuiJIng
 * @date 2021-5-13 9:46
 */
public interface AccountTransferService {
    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);
}
