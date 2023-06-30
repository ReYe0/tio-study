package com.asurplus.common.packet;

import org.tio.core.intf.Packet;

/**
 * 应用层包，需要继承 Packet 使用
 */
public class HelloPacket extends Packet {

    private static final long serialVersionUID = -172060606924066412L;

    /**
     * 消息头的长度
     */
    public static final int HEADER_LENGTH = 4;
    /**
     * 编码格式
     */
    public static final String CHAR_SET = "utf-8";
    /**
     * 消息体
     */
    private byte[] body;

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
