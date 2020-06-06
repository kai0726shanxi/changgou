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
import org.springframework.web.bind.annotation.*;
import utils.Result;



@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


   @Autowired
 private UserService userService;


   @PostMapping("/login")
    public  Result<UserBean> loginInfo(@RequestBody UserBean userBean){

    return userService.login(userBean);
   }


   @PostMapping(value = "/register", consumes = "application/json")
   public Result<UserBean>  register(@RequestBody UserBean userBean){


       return userService.register(userBean);
   }





}
