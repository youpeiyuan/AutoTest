package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

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


    /**
     * 要求客户端携带cookies进行访问
     */
    @RequestMapping(value = "/get/cookies",method = RequestMethod.GET)
    public String getwithcookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "必须携带cookies才能访问";
        }
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "这是需要携带cookies信息才能访问的Get请求";
            }
        }
        return "cookies error";
    }
}
