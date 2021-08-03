package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我的全部get方法")
public class myGetMethod {

    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "GET")
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
    @ApiOperation(value = "这是需要携带cookies信息才能访问的Get请求",httpMethod = "GET")
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


    /**
     * 开发需要携带参数才能访问的get请求
     * 第一种实现方式：url key=value&key=value
     * 模拟获取商品列表
     */
    //第一种方式，参数中添加requestparam方法
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求第一种方法",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鸿星尔克篮球鞋",249);
        myList.put("鸿星尔克运动服",239);
        myList.put("鸿星尔克遮阳帽",99);
        return myList;
    }

    //第二种方式，参数这种添加pathvariable方法
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的get请求第二种方法",httpMethod = "GET")
    public Map getList2(@PathVariable Integer start,
                        @PathVariable Integer end){
        Map<String,Integer> mylist = new HashMap<>();
        mylist.put("鸿星尔克衬衫",198);
        mylist.put("鸿星尔克休闲裤",159);
        mylist.put("鸿星尔克袜子",5);
        return mylist;
    }
}
