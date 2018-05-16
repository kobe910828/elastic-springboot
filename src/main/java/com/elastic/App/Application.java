package com.elastic.App;

//import com.elastic.config.EmbedZookeeperServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author xin.huang
 * @version v1.0
 * @date 2018/5/10 15:46
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.elastic")
public class Application {
    public static void main(String[] args) {
//        EmbedZookeeperServer.start(6181); // 启动内嵌zookeeper
        SpringApplication.run(Application.class, args);
    }
}
