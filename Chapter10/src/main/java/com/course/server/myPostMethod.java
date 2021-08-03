package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是全部post请求")
@RequestMapping("/v1")
public class myPostMethod {
    //设置一个参数来装cookies
    private static Cookie cookie;
    //用户登录成功获取到cookie，然后再登录其他接口
    @RequestMapping(value = "/logins",method = RequestMethod.POST)
    @ApiOperation(value = "这是post方法获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "passWord",required = true) String passWord){
        if (userName.equals("yangliqing")&&passWord.equals("123456")){
            cookie= new Cookie("loing","true");
            response.addCookie(cookie);
            return "恭喜你登录成功";
        }
        return "用户名或密码错误";
    }

}
