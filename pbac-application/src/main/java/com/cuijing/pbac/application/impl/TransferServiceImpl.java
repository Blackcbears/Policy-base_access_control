package com.cuijing.pbac.application.impl;

import com.cuijing.pbac.application.TransferService;
import com.cuijing.pbac.types.*;
import com.cuijing.pbac.domain.entity.Account;
import com.cuijing.pbac.domain.service.AccountTransferService;
import com.cuijing.pbac.domain.types.AuditMessage;
import com.cuijing.pbac.external.ExchangeRateService;
import com.cuijing.pbac.messaging.AuditMessageProducer;
import com.cuijing.pbac.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author CuiJIng
 * @date 2021-5-13 10:30
 */
@Component
public class TransferServiceImpl implements TransferService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AuditMessageProducer auditMessageProducer;
    @Autowired
    private ExchangeRateService exchangeRateService;
    @Autowired
    private AccountTransferService accountTransferService;

    @Override
    public boolean transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        // 参数校验
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));
        UserId userId = new UserId(sourceUserId);
        // 读数据
        Account sourceAccount = accountRepository.find(userId);
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = new AuditMessage(userId, sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);

        return true;
    }

    @Override
    public String createAccount(String accountNumber,String currency,BigDecimal dailyLimit) {
        Money money = new Money(new BigDecimal(0), new Currency(currency));
        Money dailyLimitMoney = new Money(dailyLimit, new Currency(currency));
        UserId userId = new UserId();
        AccountNumber accountNumber1 = new AccountNumber(accountNumber);

        Account account = new Account(accountNumber1,userId,money,dailyLimitMoney);
        return accountRepository.save(account).getAccountNumber().getValue();
    }
}