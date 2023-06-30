package com.asurplus.client;

import com.asurplus.client.starter.ClientStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClientApplication.class, args);
        System.out.println("-------------------------------------\n" +
                "(♥◠‿◠)ﾉﾞ  客户端启动成功   ლ(´ڡ`ლ)ﾞ\n" +
                "-------------------------------------");
        // 启动客户端
        ClientStarter.run();
    }
}
