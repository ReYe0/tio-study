package com.asurplus.server.handle;

import com.asurplus.common.handle.AbstractAioHandler;
import com.asurplus.common.packet.HelloPacket;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;

/**
 * 服务端处理器
 *
 * @author asurplus
 */
public class MyServerAioHandler extends AbstractAioHandler implements ServerAioHandler {

    /**
     * 处理消息
     */
    @Override
    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
        HelloPacket helloPacket = (HelloPacket) packet;
        byte[] body = helloPacket.getBody();
        if (body != null) {
            String str = new String(body, HelloPacket.CHAR_SET);
            System.out.println("收到消息来自客户端：" + channelContext.getId() + "的消息：" + str);

            HelloPacket resp = new HelloPacket();
            resp.setBody(("服务端已经收到了你的消息，你的消息是:" + str).getBytes(HelloPacket.CHAR_SET));
            Tio.send(channelContext, resp);
        }
    }
}
