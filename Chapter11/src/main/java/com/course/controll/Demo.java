package com.course.controll;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "v1",description = "这是我的第一个databis的demo")
@RequestMapping("v1")
public class Demo {
    @Autowired
    private SqlSessionTemplate template;

    //数据库查询接口
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表数量",httpMethod = "GET")
    public int getUserCount(){
       return template.selectOne("getUserCount");
    }

    //增加用户接口
    @RequestMapping(value = "/addUser",method =RequestMethod.POST)
    public int addUser(@RequestBody User user){
        return template.insert("addUser",user);
    }

    //更新用户信息接口
    @RequestMapping(value = "/updataUser",method = RequestMethod.POST)
    public int updataUser(@RequestBody User user){
        return template.update("updataUser",user);
    }

    //删除用户接口
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }

}
