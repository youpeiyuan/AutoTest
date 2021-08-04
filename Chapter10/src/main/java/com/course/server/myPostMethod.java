package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getuserlist",method = RequestMethod.POST)
    @ApiOperation(value = "获取列表的post接口",httpMethod = "POST")
    public String getuserlist(HttpServletRequest request,
                            @RequestBody User u){
        User user;
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for (Cookie c:cookies){
            if (c.getName().equals("login") && c.getValue().equals("true") && u.getUserName().equals("yangliqing")&&u.getPassWord().equals("123456")){
                user = new User();
                user.setName("xiaohundan");
                user.setAge("20");
                user.setSex("nan");
                return user.toString();
            }
        }
        return "参数错误";
    }

}
