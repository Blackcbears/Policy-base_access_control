package com.cuijing.pbac.domain.service.impl;

import com.cuijing.pbac.domain.entity.Account;
import com.cuijing.pbac.domain.service.AccountTransferService;
import com.cuijing.pbac.external.ExchangeRateService;
import com.cuijing.pbac.types.ExchangeRate;
import com.cuijing.pbac.types.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @author CuiJIng
 * @date 2021-5-13 9:55
 */
@Component
public class AccountTransferServiceImpl implements AccountTransferService {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.withdraw(sourceMoney);
        targetAccount.deposit(targetMoney);
    }
}
