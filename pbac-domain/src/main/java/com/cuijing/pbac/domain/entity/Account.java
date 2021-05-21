package com.cuijing.pbac.domain.entity;

import com.cuijing.pbac.ddd.Entity;
import com.cuijing.pbac.exception.InvalidCurrencyException;
import com.cuijing.pbac.types.*;
import com.cuijing.pbac.exception.DailyLimitExceededException;
import com.cuijing.pbac.exception.InsufficientFundsException;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @author CuiJIng
 * @date 2021-5-13 9:37
 */
@Getter
@AllArgsConstructor
public class Account implements Entity {
    /**
     * id
     */
    private AccountId id;
    /**
     * 
     */
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    public Account(AccountNumber accountNumber,UserId userId,Money available,Money dailyLimit){
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.available = available;
        this.dailyLimit = dailyLimit;
        this.id =new AccountId();
    }
    public Currency getCurrency() {
        return this.available.getCurrency();
    }

    /**
     * 转入
     * @param money 金额
     */
    public void deposit(Money money) {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException();
        }
        this.available = this.available.add(money);
    }

    /**
     * 转出
     * @param money 金额
     */
    public void withdraw(Money money) {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
        this.available = this.available.subtract(money);
    }
}
