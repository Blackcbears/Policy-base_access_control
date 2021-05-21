package com.cuijing.pbac.web;

import com.cuijing.pbac.application.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @author CuiJIng
 * @date 2021-5-13 11:48
 */
@Api(value = "报账", tags = "报账接口")
@RestController
public class TransferController {
    @Resource
    private TransferService transferService;


    @ApiOperation(value = "111", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "targetAccountNumber", value = "转账对象", paramType = "query", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "amount", value = "转账金额", paramType = "query", required = true, dataTypeClass = BigDecimal.class),})
    @RequestMapping(value = "/a")
    public boolean transfer(String targetAccountNumber, BigDecimal amount, @NotNull HttpSession session) {
        long userId;
        userId = 1393002710017757185L;
        return transferService.transfer(userId, targetAccountNumber, amount, "CNY");
    }

    @ApiOperation(value = "2222", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountNumber", value = "员工编号", paramType = "query", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "currency", value = "币种", paramType = "query", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "dailyLimit", value = "限制金额", paramType = "query", required = true, dataTypeClass = BigDecimal.class),})
    @RequestMapping(value = "/b")
    public String test(String accountNumber, String currency, BigDecimal dailyLimit) {
        return transferService.createAccount(accountNumber, currency, dailyLimit);
    }
}