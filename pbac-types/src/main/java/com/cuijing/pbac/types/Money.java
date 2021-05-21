package com.cuijing.pbac.types;

import com.cuijing.pbac.ddd.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author CuiJIng
 * @date 2021-5-13 9:27
 */
@EqualsAndHashCode
@Getter
@ToString
public class Money implements ValueObject, Comparable {
    private final BigDecimal value;
    private final Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Money add(Money money) {
        return new Money(value.add(money.value), currency);
    }

    @Override
    public int compareTo(Object o) {
        return value.compareTo(((Money) o).getValue());
    }

    public Money subtract(Money money) {
        return new Money(value.subtract(money.value), currency);
    }


}
