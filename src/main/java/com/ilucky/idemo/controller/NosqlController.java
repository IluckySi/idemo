//package com.ilucky.idemo.controller;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.Jedis;
//
//@RestController
//@RequestMapping("/nosql")
//public class NosqlController {
//
//    private static final String REDIS_IP = "10.0.3.160";
//    private static final int REDIS_PORT = 6379;
//    private static final String MEMCACHED_IP = "10.0.3.160";
//    private static final int MEMCACHED_PORT = 6379;
//
//
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis(REDIS_IP, REDIS_PORT);
//        jedis.set("key", "value");
//        System.out.println(jedis.get("key"));
//
//
//    }
//
//    @RequestMapping(value="/redis/{name}")
//    public String redis(@PathVariable("name") String name) {
//        try {
//            Jedis jedis = new Jedis(IP, PORT);
//            jedis.set(name, name);
//            return "redis set(" + name +")";
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
//
//    // TODO: Xmemcached
//    @RequestMapping(value="/xmemcached/{name}")
//    public String redis(@PathVariable("name") String name) {
//        try {
//            Jedis jedis = new Jedis(IP, PORT);
//            jedis.set(name, name);
//            return "redis set(" + name +")";
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
//
//
//    // TODO: Hbase
//
//    // TODO: Clickhouse
//
//    // TODO:
//}
