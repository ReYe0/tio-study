package com.asurplus.client.starter;

import com.asurplus.client.handle.MyClientAioHandler;
import com.asurplus.client.listener.MyClientAioListener;
import com.asurplus.common.consts.Const;
import com.asurplus.common.packet.HelloPacket;
import org.tio.client.ClientChannelContext;
import org.tio.client.ClientTioConfig;
import org.tio.client.ReconnConf;
import org.tio.client.TioClient;
import org.tio.client.intf.ClientAioHandler;
import org.tio.client.intf.ClientAioListener;
import org.tio.core.Node;
import org.tio.core.Tio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户端启动类
 *
 * @author lizhou
 */
public class ClientStarter {

    /**
     * 构建服务器节点
     */
    public static Node serverNode = new Node(Const.SERVER, Const.PORT);

    /**
     * handler, 包括编码、解码、消息处理
     */
    public static ClientAioHandler clientAioHandler = new MyClientAioHandler();

    /**
     * 事件监听器，可以为null，但建议自己实现该接口，可以参考showcase了解些接口
     */
    public static ClientAioListener clientAioListener = new MyClientAioListener();

    /**
     * 断链后自动连接的，不想自动连接请设为null，间隔5秒，重试10次
     */
    private static ReconnConf reconnConf = new ReconnConf(3000L, 10);

    /**
     * 一组连接共用的上下文对象
     */
    public static ClientTioConfig clientTioConfig = new ClientTioConfig(clientAioHandler, clientAioListener, reconnConf);

    /**
     * 客户端入口
     */
    public static TioClient tioClient = null;

    /**
     * 客户端TCP连接上下文
     */
    public static ClientChannelContext clientChannelContext = null;

    /**
     * 启动程序入口
     */
    public static void run() throws Exception {
        // 服务名称
        clientTioConfig.setName("T-io Client");
        // 心跳超时时间
        clientTioConfig.setHeartbeatTimeout(Const.TIMEOUT);
        tioClient = new TioClient(clientTioConfig);
        // 连接到服务器
        clientChannelContext = tioClient.connect(serverNode);
        // 连上后，给服务端发条消息
        sendMsg("你好呀，现在是" + getYmdHms());
    }

    /**
     * 发送消息
     *
     * @throws Exception
     */
    private static void sendMsg(String msg) throws Exception {
        HelloPacket packet = new HelloPacket();
        packet.setBody((msg).getBytes(HelloPacket.CHAR_SET));
        Tio.send(clientChannelContext, packet);
    }

    /**
     * 时间格式化
     *
     * @return
     */
    public static String getYmdHms() {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return df.format(new Date());
    }
}