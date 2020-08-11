package com.ilucky.idemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class IDemoApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SpringApplication.run(IDemoApp.class, args);
    }
}
