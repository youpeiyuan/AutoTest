package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取url和httpclient对象")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
    @Test(groups = "loginTrue",description = "用户登录成功接口")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase logincase = session.selectOne("loginCase",1);
        System.out.println(logincase.toString());
        System.out.println(TestConfig.loginUrl);
    }
    @Test(groups = "loginfalse",description = "用户登录失败接口")
    public void loginfalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase logincase = session.selectOne("loginCase",2);
        System.out.println(logincase.toString());
        System.out.println(TestConfig.loginUrl);
    }

}
