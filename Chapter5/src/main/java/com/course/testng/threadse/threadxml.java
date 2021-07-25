package com.course.testng.threadse;

import org.testng.annotations.Test;

public class threadxml {
    @Test
    public void test1(){
        System.out.printf("thread id : %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("thread id : %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("thread id : %s%n",Thread.currentThread().getId());
    }
}
