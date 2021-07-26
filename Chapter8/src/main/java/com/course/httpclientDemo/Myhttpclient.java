package com.course.httpclientDemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class Myhttpclient {
    //创建第一个httpclient请求
    @Test
    public void test1() throws IOException {
        //用来存放测试结果
        String resuit;
        //添加一个请求地址
        HttpGet get =new HttpGet("http://www.baidu.com");
        //添加client方法，用来执行get请求
        HttpClient client = new DefaultHttpClient();
        //添加HTTPResponse对象获取response返回值
        HttpResponse response = client.execute(get);
        //获取整个响应的整体内容,EntityUtils.toString转换成字符串
        resuit = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(resuit);
    }
}
