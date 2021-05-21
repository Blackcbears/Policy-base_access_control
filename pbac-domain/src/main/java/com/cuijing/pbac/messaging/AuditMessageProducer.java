package com.cuijing.pbac.messaging;

import com.cuijing.pbac.domain.types.AuditMessage;

/**
 * @author CuiJIng
 * @date 2021-5-13 10:06
 */
public interface AuditMessageProducer {
    /**
     * 发送基本消息
     * @param message 消息体
     * @return 是否发送成功
     */
    boolean send(AuditMessage message);
}
