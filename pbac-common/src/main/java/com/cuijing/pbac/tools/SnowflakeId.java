package com.cuijing.pbac.tools;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <br>
 *
 * @author cuijing
 * @className SnowflakeId
 * @date 2021-05-13 22:14
 */
public class SnowflakeId implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException {
        Sequence sequence = null;
        try {
            sequence = new Sequence(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return sequence.nextId();
    }

    @Override
    public boolean supportsJdbcBatchInserts() {
        return IdentifierGenerator.super.supportsJdbcBatchInserts();
    }
}
