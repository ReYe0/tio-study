package com.asurplus.client.handle;

import com.asurplus.common.handle.AbstractAioHandler;
import com.asurplus.common.packet.HelloPacket;
import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;

/**
 * 客户端处理器
 *
 * @author asurplus
 */
public class MyClientAioHandler extends AbstractAioHandler implements ClientAioHandler {

    /**
     * 心跳包
     */
    private static HelloPacket HEARTBEAT_PACKET = new HelloPacket();

    /**
     * 处理消息
     */
    @Override
    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
        HelloPacket helloPacket = (HelloPacket) packet;
        byte[] body = helloPacket.getBody();
        if (body != null) {
            String str = new String(body, HelloPacket.CHAR_SET);
            System.out.println("收到消息：" + str);
        }
    }

    /**
     * 此方法如果返回null，框架层面则不会发心跳；如果返回非null，框架层面会定时发本方法返回的消息包
     */
    @Override
    public Packet heartbeatPacket(ChannelContext channelContext) {
        return HEARTBEAT_PACKET;
    }
}
