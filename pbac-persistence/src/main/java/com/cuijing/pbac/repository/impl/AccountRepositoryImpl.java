package com.cuijing.pbac.repository.impl;

import com.cuijing.pbac.domain.entity.Account;
import com.cuijing.pbac.persistence.AccountDO;
import com.cuijing.pbac.repository.AccountRepository;
import com.cuijing.pbac.types.AccountId;
import com.cuijing.pbac.types.AccountNumber;
import com.cuijing.pbac.types.UserId;
import com.cuijing.pbac.persistence.AccountBuilder;
import com.cuijing.pbac.persistence.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author CuiJIng
 * @date 2021-5-13 10:47
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountBuilder accountBuilder;


    @Override
    public Account find(AccountId id) {
        Optional<AccountDO> accountDO = accountDAO.findById(id.getValue());
        return accountDO.map(aDo -> accountBuilder.toAccount(aDo)).orElse(null);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountDO accountDO = accountDAO.findByAccountNumber(accountNumber.getValue());
        if (accountDO != null) {
            return accountBuilder.toAccount(accountDO);
        }
        return null;
    }

    @Override
    public Account find(UserId userId) {
        AccountDO accountDO = accountDAO.findByUserId(userId.getId());
        if (accountDO != null) {
            return accountBuilder.toAccount(accountDO);
        }
        return null;
    }

    @Override
    public Account save(Account account) {
        AccountDO accountDO = accountBuilder.fromAccount(account);
        accountDAO.saveAndFlush(accountDO);
        return accountBuilder.toAccount(accountDO);
    }
}