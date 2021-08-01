package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class myGetMethod {
    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    public String getcookies(HttpServletResponse response){
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类
        Cookie cookies = new Cookie("login","true");
        response.addCookie(cookies);
        return "恭喜你获取cookies成功";
    }
}
