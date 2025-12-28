//package com.ilucky.idemo.test;
//
//public class InnerClassTest {
//
//    private String outer;
//
//    public InnerClassTest(Builder builder) {
//       this.outer = builder.inner;
//    }
//
//    private void getBuilder() {
//        System.out.println(new Builder("xxx").inner);
//        System.out.println(Builder.staticInner);
//    }
//
//    static class Builder {
//
//        private String inner;
//        private static String staticInner = "yyy";
//
//        Builder(String name) {
//            this.inner = name;
//        }
//
//        public InnerClassTest request() {
//            return
//        }
//    }
//
//    public static void main(String[] args) {
////        InnerClassTest.Builder builder = new InnerClassTest.Builder("inner");
////        String inner = builder.inner;
////        System.out.println(inner);
//
//        InnerClassTest outer = new InnerClassTest();
//        outer.getBuilder();
//
//
//        // System.out.println(inner);
//    }
//}