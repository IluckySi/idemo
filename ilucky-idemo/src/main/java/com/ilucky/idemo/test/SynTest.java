package com.ilucky.idemo.test;

import java.util.concurrent.atomic.AtomicLong;

public class SynTest {

    private byte[] lock = new byte[0];
    private static AtomicLong beforeSyn = new AtomicLong(0);
    private static AtomicLong afterSyn = new AtomicLong(0);

    public static void main(String[] args)  {

        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("beforeSyn:" + beforeSyn);
                    System.out.println("afterSyn:" + afterSyn);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

        final SynTest test = new SynTest();
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        // app_request_all
                        test.test(); // chain
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   // System.out.println("---------");
                }
                System.out.println("==");
            }
        });
        t2.start();

    }

    public void test () throws InterruptedException {
        beforeSyn.incrementAndGet();
        int i = 1;
        int j = 10;
        synchronized (this.lock) {
            Thread.sleep(1000);
            afterSyn.incrementAndGet();
        }
    }
}
