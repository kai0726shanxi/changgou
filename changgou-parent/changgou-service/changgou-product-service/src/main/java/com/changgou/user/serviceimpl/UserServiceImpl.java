package com.changgou.user.serviceimpl;

/*
 *功能描述
 * @author gao
 * @date 2020-06-02
 * @description 用户接口实现$
 */

import com.changgou.CodeMassage;
import com.changgou.user.entity.UserBean;
import com.changgou.user.mapper.UserMapper;
import com.changgou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import utils.Result;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private  UserMapper userMapper;

    @Override
    public Result<UserBean> login(UserBean userBean) {

        return null;
    }

    @Override
    public Result<UserBean> register(UserBean userBean) {
        UserBean userBean1=new UserBean();
        userBean1.setUserAccount(userBean.getUserAccount());
        userBean1.setUserPsw(userBean.getUserPsw());
        if(StringUtils.isEmpty(userBean1.getUserAccount())||StringUtils.isEmpty(userBean1.getUserPsw())){
            return Result.error(-1, CodeMassage.ACCOUNT_OR_PSW_NOT_NULL);
        }
        int userCount = userMapper.selectCount(userBean1);
        if (userCount>0){

            return Result.error(CodeMassage.ACCOUNT_EXIT);
        }
        int i = userMapper.insertSelective(userBean1);
       if (i>0){

       userBean1 =userMapper.selectOne(userBean1);

       }
     return  Result.success(userBean1);
    }
}
