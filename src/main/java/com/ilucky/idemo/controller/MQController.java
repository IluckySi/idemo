package com.ilucky.idemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mq
 */
@RestController
@RequestMapping("/mq")
public class MQController {

    private static final String KAFAK_IP = "";

    // kafka
    @RequestMapping(value="/kafka/produce/{msg}")
    public String kafka_produce(@PathVariable("msg") String msg) {

        return "kafka/produce(msg="+msg+")";
    }

    @RequestMapping(value="/kafka/consumer")
    public String kafka_consumer() {
        String msg = "";
        return "kafka/consumer(msg="+msg+")";
    }


    // rabbitmq

    // rocketmq

    // activemq

    // zeromq

    // ibmmq
}
