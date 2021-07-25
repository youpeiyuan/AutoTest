package com.course.testng;

import org.testng.annotations.*;

//这是最基本的注解，用来把方法标记为测试的一部分
public class BasecAnnotation {
    @Test
    public void testCase1(){
        System.out.printf("Thread id : %s%n",Thread.currentThread().getId());
        System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public void beforemethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("BeforeMethod这是在类运行前运行的");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("AfterClass这是在类运行后运行的");
    }
    @BeforeSuite
    public void beforesuit(){
        System.out.println("BeforeSuit这是类运行前运行的套件");
    }
    @AfterSuite
    public void aftersuit(){
        System.out.println("AfterSuit这是类运行后运行的套件");
    }
}
