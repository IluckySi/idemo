package com.ilucky.idemo.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okhttp3.Request;

/**
 * OKHttp Test测试
 */
public class OKHttpTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Request request = new Request.Builder().url("http://localhost:8080").addHeader("key", "value").build();
        // System.out.println(request.header("key"));

        // headers
//        Method headersMethod = request.getClass().getMethod("headers");
//        System.out.println(headersMethod);
//        Object headers = headersMethod.invoke(request);
//        System.out.println(headers);
        System.out.println(request.headers());

        Class[] cs = request.getClass().getDeclaredClasses();
        for(Class c : cs) {
            System.out.println(c);


           // Class rb = Class.forName("okhttp3.Request$Builder");
           // Object co = c.getConstructor(new Class[]{rb}).newInstance(new Object[]{request});
//            Object co = c.getConstructor().newInstance();
//            getHeaderMethod.invoke(co, new Object[]{"k2", "v2"});
           // Object co = c.getConstructor(new Class[]{request.getClass()}).newInstance(new Object[]{request});
            Constructor coConstructor = c.getDeclaredConstructor(new Class[]{request.getClass()});
            coConstructor.setAccessible(true);
            Object co = coConstructor.newInstance(new Object[]{request});

            Method addHeaderMethod = c.getMethod("addHeader", new Class[]{String.class, String.class});
            System.out.println(addHeaderMethod);
            addHeaderMethod.invoke(co, new Object[]{"k2", "v2"});

            Method buildMethod = c.getMethod("build");
            System.out.println(buildMethod);
            request = (Request)buildMethod.invoke(co);


           //
            // request.getClass().getokhttp3.Request$Builder
        }

        // headers

        System.out.println("---------------");
//        Method headersMethod2 = request.getClass().getMethod("headers");
//        System.out.println(headersMethod2);
//        Object headers2 = headersMethod.invoke(request);
//        System.out.println(headers2);

        System.out.println(request.headers());
    }
}
