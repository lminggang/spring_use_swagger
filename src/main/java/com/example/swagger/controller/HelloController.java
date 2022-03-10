package com.example.swagger.controller;

import com.example.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Hello 控制类")
@RestController
public class HelloController {

    @ApiOperation("hello 接口")
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("hello_user 接口")
    @GetMapping(value = "/hello_user")
    public String hello_user(@ApiParam("用户名") @PathVariable String username) {
        return "hello " + username;
    }

    @ApiOperation("获取 user 数据接口")
    @GetMapping(value = "/user")
    public User user() {
        return new User();
    }

    @ApiOperation(value = "提交 user 数据接口", notes = "描述信息")
    @PostMapping(value = "/user")
    public User user(@ApiParam("用户实例") @RequestBody User user) {
        return user;
    }
}
