package com.cuijing.pbac.persistence;

import com.cuijing.pbac.domain.entity.Account;
import com.cuijing.pbac.types.*;
import org.springframework.stereotype.Component;
/**
 * @author CuiJIng
 * @date 2021-5-13 10:46
 */
@Component
public class AccountBuilder {
    public Account toAccount(AccountDO accountDO) {
        Currency currency = new Currency(accountDO.getCurrency());
        return new Account(new AccountId(accountDO.getId()), new AccountNumber(accountDO.getAccountNumber()),
                new UserId(accountDO.getUserId()), new Money(accountDO.getAvailable(), currency),
                new Money(accountDO.getDailyLimit(), currency));
    }

    public AccountDO fromAccount(Account account) {
        return new AccountDO(account.getId().getValue(),
                account.getAccountNumber().getValue(),
                account.getUserId().getId(),
                account.getAvailable().getValue(),
                account.getDailyLimit().getValue(),
                account.getCurrency().getValue());
    }
}