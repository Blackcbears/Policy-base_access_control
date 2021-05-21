package com.cuijing.pbac.types;

import com.cuijing.pbac.tools.Sequence;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author CuiJIng
 * @date 2021-5-13 9:27
 */
@Getter
@EqualsAndHashCode
@ToString
public class UserId {
    private final Long id;
    public UserId(Long id) {
        this.id = id;
    }
    public UserId() {
        Sequence sequence = null;
        try {
            sequence = new Sequence(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        this.id = sequence.nextId();
    }
}
