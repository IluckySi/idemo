package com.ilucky.idemo.util.thread;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;

public class ThreadLocalUtil {


    private static ThreadLocal<HashMap<String, Object>> dataTransferTL = new ThreadLocal<HashMap<String, Object>>() {
        protected HashMap<String, Object> initialValue() {
            return new HashMap<String, Object>(7);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        // test1();
        test2();
    }

    public static void test2() throws InterruptedException {
        HashMap<String, Object> hashMap = dataTransferTL.get();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    hashMap.put("i"+i, "Thread1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    hashMap.put("i"+i, "Thread2");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(JSON.toJSONString(hashMap));
    }

    public static void test1() {
        HashMap<String, Object> map = dataTransferTL.get();
        Object o = new Object();
        map.put("Test", o);
        // dataTransferTL.set(map);

        HashMap<String, Object> map2 = dataTransferTL.get();
        Object o2 = new Object();
        map2.put("Test", o2);
        // dataTransferTL.set(map);

        System.out.println(JSON.toJSONString(map2));
    }
}
