package com.cuijing.pbac.persistence;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * @author CuiJIng
 * @date 2021-5-13 10:48
 */
@Entity
@Table(name="account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDO {
    @Id
    @GeneratedValue(generator = "snowFlakeId")
    @GenericGenerator(name = "snowFlakeId", strategy = "com.cuijing.pbac.tools.SnowflakeId")
    private Long id;
    private String accountNumber;
    private Long userId;
    private BigDecimal available;
    private BigDecimal dailyLimit;
    private String currency;


}
