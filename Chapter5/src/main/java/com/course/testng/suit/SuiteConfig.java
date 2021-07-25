package com.course.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("BeforeSuite运行啦");
    }
    @AfterSuite
    public void aftersuit(){
        System.out.println("Aftersuite运行啦");
    }
}
