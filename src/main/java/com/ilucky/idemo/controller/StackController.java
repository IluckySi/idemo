package com.ilucky.idemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 堆栈层级
 * v1.0
 */
@RestController
@RequestMapping("/stack")
public class StackController {

    // 递归
    @RequestMapping("/recursion/{size}/{sleep}")
    public String recursion(@PathVariable("size") long size,
        @PathVariable("sleep") long sleep) {
        beginRecursion (size, sleep);
        return "recursion (" + size +", " + sleep +")";
    }

    // 循环
    @RequestMapping("/cycle/{size}/{sleep}")
    public String cycle(@PathVariable("size") long size,
        @PathVariable("sleep") long sleep) {
        beginCycle (size, sleep);
        return "cycle (" + size +", " + sleep +")";
    }

    private void beginRecursion (long size, long sleep) {
        if (size <= 0) return;
        business(sleep);
        beginRecursion(size - 1, sleep);
    }

    private void beginCycle (long size, long sleep) {
        for (long i = 0; i < size; i++) {
            business(sleep);
        }
    }

    // 模拟业务
    private void business(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
