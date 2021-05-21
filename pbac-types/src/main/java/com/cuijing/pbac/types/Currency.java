package com.cuijing.pbac.types;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author CuiJIng
 * @date 2021-5-13 9:26
 */
@Getter
@EqualsAndHashCode
@ToString
public class Currency {
    private final String value;

    public Currency(String value) {
        this.value = value;
    }
}
