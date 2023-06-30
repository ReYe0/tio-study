# tio-study

#### 介绍
    学习 t-io 的第一步

#### 使用说明
    1. 分为 server 和 client 工程，server 和 client 共用 common 工程
    2. 服务端和客户端的消息协议比较简单，消息头为 4 个字节，用以表示消息体的长度，消息体为一个字符串的byte[]
    3. 服务端先启动，监听 6789 端口
    4. 客户端连接到服务端后，会主动向服务器发送一条消息
    5. 服务器收到消息后会回应一条消息
    6. 之后，框架层会自动从客户端发心跳到服务器，服务器也会检测心跳有没有超时（这些事都是框架做的，业务层只需要配一个心跳超时参数即可）
    7. 框架层会在断链后自动重连（这些事都是框架做的，业务层只需要配一个重连配置对象即可）
 
#### 版本说明
    使用的t-io.core 版本为 3.7.4.v20210808-RELEASE

### 使用说明

 1. 启动服务端 ServerApplication

<center>
    <img style="border-radius: 20px;"
         src="https://gitee.com/asurplus/tio-study/raw/master/img/server.jpg" 
         alt=""
         height="200"
         width="100%" >
</center>

 2. 启动客户端 ClientApplication

<center>
    <img style="border-radius: 20px;"
         src="https://gitee.com/asurplus/tio-study/raw/master/img/client.jpg" 
         alt=""
         height="200"
         width="100%" >
</center>

 3. 客户端断线重连
 
<center>
    <img style="border-radius: 20px;"
         src="https://gitee.com/asurplus/tio-study/raw/master/img/reconnect.jpg" 
         alt=""
         height="200"
         width="100%" >
</center>
