package com.ilucky.idemo.test;


public class PPTTest {

    public static void main(String[] args) {
        while (true) {
            System.out.println("==============");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
