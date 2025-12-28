package com.ilucky.idemo.util.test;

public class Main {
    public static void main(String[] args) {
        String str = "我是xxxxxxxxxxxxxxxx1234567890yyyyyyyyyyy中国abcdefghijklmnopqrstuvwxyz人";
        String key = "wxyz人";
        long start = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
           containsTest(str, key);
            // indexOfTest(str, key);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void containsTest(String str ,String key) {
        boolean i = str.contains(key);
    }

    public static void indexOfTest(String str ,String key) {
        int i = str.indexOf(key);
    }
}
