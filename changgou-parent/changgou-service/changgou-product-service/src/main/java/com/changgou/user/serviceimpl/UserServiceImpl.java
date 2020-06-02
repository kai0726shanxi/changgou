package com.changgou.user.serviceimpl;

/*
 *功能描述
 * @author gao
 * @date 2020-06-02
 * @description 用户接口实现$
 */

import com.changgou.user.entity.UserBean;
import com.changgou.user.mapper.UserMapper;
import com.changgou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Result;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void saveUserInfo(UserBean userBean) {
        userMapper.insertSelective(userBean);
    }

    @Override
    public void deleteUserInfo(Long id) {

    }

    @Override
    public Result<List<UserBean>> findAll() {
        return Result.success(userMapper.selectAll());
    }

    @Override
    public Result<UserBean> findById(Long id) {
        UserBean userBean=new UserBean();
        userBean.setUserId(id);
        return Result.success(userMapper.selectByPrimaryKey(userBean));
    }
}
