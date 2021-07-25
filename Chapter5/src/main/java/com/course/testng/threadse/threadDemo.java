package com.course.testng.threadse;

import org.testng.annotations.Test;

public class threadDemo {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println("11111111111");
        System.out.printf("Thread id : %s%n",Thread.currentThread().getId());
    }
}
