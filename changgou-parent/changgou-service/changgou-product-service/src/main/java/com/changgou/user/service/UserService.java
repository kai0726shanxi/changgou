package com.changgou.user.service;

import com.changgou.user.entity.UserBean;
import utils.Result;

import java.util.List;

/***
 * 用户服务
 */
public interface UserService {

    /***
     * 新增用户
     * @param userBean
     */
    void saveUserInfo(UserBean userBean);
    void  deleteUserInfo(Long  id);
    Result<List<UserBean>>  findAll();
    Result<UserBean> findById(Long id);

}
