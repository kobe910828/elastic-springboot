//package com.elastic.config;
//
//import org.apache.curator.test.TestingServer;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * 内嵌Zookeeper配置
// *
// * @author xin.huang
// * @version v1.0
// * @date 2018/5/10 15:33
// */
//public class EmbedZookeeperServer {
//    private static TestingServer testingServer;
//
//    public static void start(final int port) {
//        try {
//            testingServer = new TestingServer(port, new File(String.format("target/test_zk_data/%s/", System.nanoTime())));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//                try {
//                    Thread.sleep(1000L);
//                    testingServer.close();
//                } catch (InterruptedException | IOException e) {
//                    e.printStackTrace();
//                }
//            }));
//        }
//    }
//}
