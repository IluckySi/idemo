package com.ilucky.idemo.controller;

import com.ilucky.idemo.util.sql.MysqlUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    // 睡眠
    @RequestMapping("/sleep/{time}")
    public String sleep(@PathVariable("time") long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread.sleep(" + time +")";
    }

    // 创建子线程
    @RequestMapping("/create/{time}")
    public String create(@PathVariable("time") final long time) {
        business(time); // 主线程业务
        new Thread(new Runnable() {
            public void run() {
                business(time);
            }
        }).run();  // 子线程业务
        return "new Thread(new Runnable(){Thead.sleep(" + time + ")})";
    }

    // 创建子线程，访问数据库
    @RequestMapping("/create2/{time}")
    public String create2(@PathVariable("time") final long time) {
        business(time); // 主线程业务
        new Thread(new Runnable() {
            public void run() {
                businessWithSQL(time);
            }
        }).run();  // 子线程业务
        return "new Thread(new Runnable(){sql(select)})";
    }

    // 锁: 访问两次观察情况, 例如第一次访问: time=10000, 第二次访问: time=1(会被阻塞)
    private static final String SYNC = "sync";
    @RequestMapping("/syn/{time}")
    public String syn(@PathVariable("time") final long time) {
        synchronized (SYNC) {
            business(time);
        }
        return "synchronized(" + time +")";
    }

    // 线程合并
//    @RequestMapping("/join/{time}")
//    public String syn(@PathVariable("time") final long time) {
//        synchronized (SYNC) {
//            business(time);
//        }
//        return "synchronized(" + time +")";
//    }

    //    @RequestMapping("/waitNotify")
//    public String sleep() {
//        Thread t = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    this.notify();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).run();
//
//        return "new Thread(new Runnable(){Thead.sleep(1000)})";
//    }

    private void business(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void businessWithSQL(long time) {
        try {
            MysqlUtil mysqlUtil = new MysqlUtil();
            String select = mysqlUtil.select();
            System.out.println(select);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
