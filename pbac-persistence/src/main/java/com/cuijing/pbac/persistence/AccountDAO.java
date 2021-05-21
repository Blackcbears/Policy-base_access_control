package com.cuijing.pbac.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author CuiJIng
 * @date 2021-5-13 10:48
 */

@Component
public interface AccountDAO extends JpaRepository<AccountDO, Long> {
    @Override
    Optional<AccountDO> findById(Long value);

    AccountDO findByAccountNumber(String value);

    AccountDO findByUserId(Long id);

    /**
     * 
     * @param accountDO
     * @return
     */
    @Override
    AccountDO saveAndFlush(AccountDO accountDO);


}