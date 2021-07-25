package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "tea")
public class groupOnMethed3 {
    public void teacher1(){
        System.out.println("这是老师组11111111");
    }
    public void teacher2(){
        System.out.println("这是老师组12222222");
    }
}
