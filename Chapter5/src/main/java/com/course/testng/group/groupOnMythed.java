package com.course.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupOnMythed {
    @Test(groups = "tests")
    public void test1(){
        System.out.println("这是测试端组11111");
    }
    @Test(groups = "tests")
    public void test2(){
        System.out.println("这是测试端组222222");
    }
    @Test(groups = "serves")
    public void test3(){
        System.out.println("这是服务端组11111");
    }
    @Test(groups = "serves")
    public void test4(){
        System.out.println("这是服务端组222222");
    }
    @BeforeGroups("tests")
    public void beforgroup(){
        System.out.println("这是运行前的组");
    }
    @AfterGroups("tests")
    public void aftergroup(){
        System.out.println("这是运行后的组");
    }
}
