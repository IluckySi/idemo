package com.ilucky.idemo.controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多线程
 */
@RestController
@RequestMapping("/multithread")
public class MultiThreadController {

    // CountDownLatch
    @RequestMapping("/countdownlatch/{count}/{sleep}")
    public String countdownlatch(@PathVariable("count") int count,
        @PathVariable("sleep") long sleep)  {
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new BusinessThreadWithCountDownLatch(countDownLatch, sleep)).run();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "CountDownLatch.execute(" + count * sleep + ")";
    }


    // ThreadPoolExecutor
    @RequestMapping("/threadpool/{count}/{sleep}")
    public String threadPool(@PathVariable("count") int count,
        @PathVariable("sleep") long sleep)  {
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            threadPoolExecutor.execute(new BusinessThread(sleep));
        }
        return "ThreadPool.execute(" + count * sleep + ")";
    }


    // TODO: CycliBarrier

    // TODO: Semaphore

    // 模拟业务
    private void business(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class BusinessThread implements Runnable {

        private long sleep;

        BusinessThread (long sleep) {
            this.sleep = sleep;
        }

        public void run() {
            business(sleep);
        }
    }

    public class BusinessThreadWithCountDownLatch implements Runnable {

        private CountDownLatch countDownLatch;
        private long sleep;

        BusinessThreadWithCountDownLatch (CountDownLatch countDownLatch, long sleep) {
            this.countDownLatch = countDownLatch;
            this.sleep = sleep;
        }

        public void run() {
            business(sleep);
            this.countDownLatch.countDown();
        }
    }
}


