package com.cuijing.pbac.application;

import com.cuijing.pbac.ddd.ApplicationService;

import java.math.BigDecimal;

/**
 * @author CuiJIng
 * @date 2021-5-13 10:29
 */
public interface TransferService extends ApplicationService {
    boolean transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) ;

    String createAccount(String accountNumber,String currency,BigDecimal dailyLimit) ;
}
