package com.course.cookiesdemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class cookiesDemo {
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforetest(){
        //ResourceBundle.getBundle方法获取配置文件
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //bundle调用getString，传入对应key，变量url接收配置的url
        url = bundle.getString("test.url");
    }
    @Test
    public void test1() throws IOException {
        String suite;
        //bundle调用getString，传入对应key，变量uri接收配置的uri
        String uri =bundle.getString("getcookies.uri");
        //调用HttpGet方法，传入url
        HttpGet get = new HttpGet(this.url+uri);
        //调用DefaulHttpclient方法，用Httpcliect类接受
        HttpClient client = new DefaultHttpClient();
        //调用连接，获取返回值，用HttpResponse接收
        HttpResponse response = client.execute(get);
        //转成String类型，打印出来
        suite = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(suite);
    }
}
