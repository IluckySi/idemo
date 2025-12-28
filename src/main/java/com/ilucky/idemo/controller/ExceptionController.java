package com.ilucky.idemo.controller;

import java.util.Arrays;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常信息
 * v1.0
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    // 抛出除0异常
    @RequestMapping("/unknow/{sleep}")
    public String unknow( @PathVariable("sleep") long sleep) {
        business(sleep);
        int i = 0;
        int j = 10;
        int r = j/i;
        return "unknow(" + sleep +")";
    }

    // 抛出ClassNotFoundException
    @RequestMapping("/unknow2/{sleep}")
    public String error (@PathVariable("sleep") long sleep) throws ClassNotFoundException {
        business(sleep);
        Class c = Class.forName("com.ilucky.test.XXXTest");
        return "error (" + sleep +")";
    }

    // 捕获异常
    @RequestMapping("/trycatch/{sleep}")
    public String trycatch ( @PathVariable("sleep") long sleep) {
        try {
            business(sleep);
            int i = 0;
            int j = 10;
            int r = j / i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "try catch(" + sleep +")";
    }

    // 手动抛出自定义异常
    @RequestMapping("/custom/{sleep}")
    public String custom (@PathVariable("sleep") long sleep) throws CustomException {
        business(sleep);
        throw new CustomException("custom");
    }

    // 循环抛出除0异常
    @RequestMapping("/cycle/{count}/{sleep}")
    public String cycle (@PathVariable("size") long count,
        @PathVariable("sleep") long sleep) {
        for(int i = 0; i < count; i++) {
            try {
                businessWithoutCatch(sleep);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "exception (" + count +" * " + sleep +")";
    }

    // 多层exception(cause)
    @RequestMapping("/cause/{sleep}")
    public String cause (@PathVariable("sleep") long sleep) throws InterruptedException {
        business(sleep);
        outer();
        return "cause";
    }

    // 自定义异常
    class CustomException extends Exception {
        public CustomException (String exception) {
            super(exception);
        }
    }

    // 模拟正常业务
    private void business(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 模拟异常业务
    private void businessWithoutCatch(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 0;
        int j = 10;
        int r = j / i;
    }

    // e.getMessage()和e.getCause().getMessage()的区别: cause是真正的异常
    private void outer () throws InterruptedException {
        try {
            inner();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.asList(e.getStackTrace()));
            Thread.sleep(1000);
            System.out.println("-------------");
            System.out.println(e.getCause().getMessage());
            System.out.println(Arrays.asList(e.getCause().getStackTrace()));

        }
    }

    // 手动抛出异常-第一层
    private void inner () throws CustomException {
        try {
            inner2();
        } catch (Exception e) {
            CustomException customEx = new CustomException("{CustomException}");
            customEx.initCause(e); // 关键代码
            throw customEx;
        }
    }

    // 手动抛出异常-第二层
    private void inner2 () throws ArithmeticException {
        try {
            int i = 0;
            int r = 10 / i;
        } catch (Exception e) {
            ArithmeticException arithEx = new ArithmeticException("{ArithmeticException}");
            arithEx.initCause(e); // 关键代码
            throw arithEx;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ExceptionController().outer();
    }
}
