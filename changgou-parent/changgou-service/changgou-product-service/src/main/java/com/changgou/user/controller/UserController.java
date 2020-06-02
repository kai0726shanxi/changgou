package com.changgou.user.controller;

/*
 *功能描述
 * @author gao
 * @date 2020-06-02
 * @description 用户接口实现$
 */

import com.changgou.user.entity.UserBean;
import com.changgou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.Result;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


   @Autowired
 private UserService userService;


 @GetMapping("/findAll")
public Result<List<UserBean>> finAll(){

    return userService.findAll();
}


@GetMapping("/hello")
public Result<String> testData(){

     return Result.success("hello");
}

}
