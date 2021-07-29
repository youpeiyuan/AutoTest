package com.course.cookiesdemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class testpostcookies {

    private String url;
    private ResourceBundle bundle;
    //用来储存cookies信息的变量
    private CookieStore cookie;
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
        DefaultHttpClient client = new DefaultHttpClient();
        //调用连接，获取返回值，用HttpResponse接收
        HttpResponse response = client.execute(get);
        //转成String类型，打印出来
        suite = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(suite);

        //获取cookies信息
        this.cookie = client.getCookieStore();
        List<Cookie> cookieList = cookie.getCookies();
        for (Cookie cookies : cookieList){
            String name = cookies.getName();
            String value = cookies.getValue();
            System.out.println("cookie name:" + name + "; cookie value:"+value);
        }
    }
    @Test(dependsOnMethods = {"test1"})
    public void postcookies() throws IOException {
        String uri = bundle.getString("postwithcookie.uri");
        String Url =this.url+uri;
        //声明一个post方法
        HttpPost post = new HttpPost(Url);
        //声明一个client方法
        DefaultHttpClient client = new DefaultHttpClient();
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","quen");
        param.put("age","25");
        //添加请求头信息
        post.setHeader("content-type","application/json");
        //添加cookies信息
        client.setCookieStore(cookie);
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象用储存响应结果
        String result;
        //执行post
        HttpResponse resopnse = client.execute(post);
        //获取响应结果
        result =  EntityUtils.toString(resopnse.getEntity(),"utf-8");
        System.out.println(result);
        //将返回的响应结果字符串转换为json对象
        JSONObject resuitjson = new JSONObject(result);
        //获取响应结果值
        String success = (String) resuitjson.get("quen");
        Object status = resuitjson.get("status");
        //判断响应结果值
        Assert.assertEquals("success",success);
        Assert.assertEquals(1,status);

    }
}
