package com.course.testng;

import org.testng.annotations.Test;

public class timeoutdemo {
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("成功");
    }
    @Test(timeOut = 2000)
    public void testFail() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("失败");
    }
}
