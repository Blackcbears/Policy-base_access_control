package com.cuijing.pbac.repository;

import com.cuijing.pbac.ddd.Repository;
import com.cuijing.pbac.domain.entity.Account;
import com.cuijing.pbac.types.AccountId;
import com.cuijing.pbac.types.AccountNumber;
import com.cuijing.pbac.types.UserId;

/**
 * @author CuiJIng
 * @date 2021-5-13 10:00
 */
public interface AccountRepository extends Repository {
    Account find(AccountId id);
    Account find(AccountNumber accountNumber);
    Account find(UserId userId);
    Account save(Account account);
}
