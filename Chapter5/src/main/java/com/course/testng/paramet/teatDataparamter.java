package com.course.testng.paramet;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class teatDataparamter {
    @Test(dataProvider = "test")
    public void dataParamters(String name, int age) {
        System.out.println("name=" + name + ", age=" + age);
    }

    @DataProvider(name = "test")
    public Object[][] dataParamterxnl() {
        Object[][] obj = new Object[][]{
                {"zhangsna", 10},
                {"lisi", 20},
                {"wangwu", 30}
        };
        return obj;
    }

    @Test(dataProvider = "method")
    public void methed1(String name, int age) {
        System.out.println("methed111" + name + "; age" + age);
    }

    @Test(dataProvider = "method")
    public void methed2(String name, int age) {
        System.out.println("methed222" + name + "; age" + age);
    }

    @DataProvider(name = "method")
    public Object[][] dataMethod(Method methods) {
        Object[][] objs = null;
        if (methods.getName().equals("methed1")) {
            objs = new Object[][]{
                    {"杨立青", 20},
                    {"瞿霞", 20}
            };
        }else if (methods.getName().equals("methed2")){
            objs=new Object[][]{
                    {"董建昌",35},
                    {"杨立华",25}
            };
        }
        return objs;
    }
}
