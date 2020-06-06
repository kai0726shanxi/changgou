package com.changgou.user.service;

import com.changgou.user.entity.UserBean;
import org.springframework.web.bind.annotation.RequestBody;
import utils.Result;


/***
 * 用户服务
 */
public interface UserService {

    /***
     * 新增用户
     * @param userBean
     */
 //登录
Result<UserBean>  login(@RequestBody UserBean userBean);
//注册
Result<UserBean> register(@RequestBody UserBean userBean);
//设置用户信息
Result<UserBean> setUserInformation(@RequestBody UserBean userBean);



//退出登录

Result loginOut();






}
