package com.asurplus.server;

import com.asurplus.server.starter.ServerStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 网关启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ServerApplication.class, args);
        System.out.println("-------------------------------------\n" +
                "(♥◠‿◠)ﾉﾞ  服务端启动成功   ლ(´ڡ`ლ)ﾞ\n" +
                "-------------------------------------");
        // 启动服务端
        ServerStarter.run();
    }
}
