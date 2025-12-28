package com.ilucky.idemo.test;

/**
 * java没有应用传递，只有值传递
 * https://www.zhihu.com/question/31203609
 */
public class HaHaTest {

    public static void main(String[] args) {
        User u = new User();
        u.setId("123");
        test(u);
      //  test2(u);
        System.out.println(u);
    }

    public static void test(User u) {
//        u = new User();
//        u.setId("234");
//        System.out.println(u);

        User u2 = new User();
        u2.setId("234");
        u = u2;
        System.out.println(u);
    }


    public static void test2(User u) {
//        u = new User();
//        u.setId("234");
//        System.out.println(u);


        User u2 = new User();
        u2.setId("234");
        u = u2;
        System.out.println(u);
    }
}


