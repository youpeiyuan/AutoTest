package com.course.testng.suit;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExpectedFail(){
        System.out.println("这是一个会失败的runtimeexpection异常");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExpectedSuccess(){
        System.out.println("这是一个会成功的runtimeexpection异常");
        throw new RuntimeException();

    }

}
