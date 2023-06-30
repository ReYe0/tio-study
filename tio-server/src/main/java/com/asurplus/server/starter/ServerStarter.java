package com.asurplus.server.starter;

import com.asurplus.common.consts.Const;
import com.asurplus.server.handle.MyServerAioHandler;
import com.asurplus.server.listener.MyServerAioListener;
import org.tio.server.ServerTioConfig;
import org.tio.server.TioServer;
import org.tio.server.intf.ServerAioHandler;
import org.tio.server.intf.ServerAioListener;

import java.io.IOException;

/**
 * 服务端启动类
 *
 * @author lizhou
 */
public class ServerStarter {

    /**
     * handler, 包括编码、解码、消息处理
     */
    public static ServerAioHandler serverAioHandler = new MyServerAioHandler();

    /**
     * 事件监听器，可以为null，但建议自己实现该接口，可以参考showcase了解些接口
     */
    public static ServerAioListener serverAioListener = new MyServerAioListener();

    /**
     * 一组连接共用的上下文对象
     */
    public static ServerTioConfig serverTioConfig = new ServerTioConfig("T-io Server", serverAioHandler, serverAioListener);

    /**
     * 服务端入口
     */
    public static TioServer tioServer = null;

    /**
     * 启动程序入口
     */
    public static void run() throws IOException {
        // 心跳超时时间
        serverTioConfig.setHeartbeatTimeout(Const.TIMEOUT);
        tioServer = new TioServer(serverTioConfig);
        // 启动服务
        tioServer.start(Const.SERVER, Const.PORT);
    }
}