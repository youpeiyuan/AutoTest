package com.course.testng.paramet;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paramterTest {
    @Test
    @Parameters({"name","age"})
    public void paramter1(String name,String age){
        System.out.println("name="+name+" age="+age);
    }
}
