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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import utils.Result;

import java.util.Date;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
   private  UserMapper userMapper;

    /**
     * 登录
     * @param userBean
     * @return
     */
    @Override
    public Result<UserBean> login(UserBean userBean) {

        if (StringUtils.isEmpty(userBean.getUserAccount())||StringUtils.isEmpty(userBean.getUserPsw())){

            return Result.error(CodeMassage.ACCOUNT_OR_PSW_NOT_NULL);
        }

        UserBean userBean1=new UserBean();
        userBean1.setUserAccount(userBean.getUserAccount());
        UserBean userBean2 = userMapper.selectOne(userBean1);
        if (userBean2!=null){
            String md5Password = DigestUtils.md5DigestAsHex(userBean.getUserPsw().getBytes());

            if (md5Password.equals(userBean2.getUserPsw())){
                userBean2.setLastLoginTime(new Date());
                userBean2.setUserPsw(null);
                return Result.success(userBean2);
            }else {
                return Result.error(CodeMassage.ACCOUNT_OR_PSW_ERROR);
            }

        }else {
         return Result.error(CodeMassage.LOGIN_ERROR);
        }


    }

    /***
     * 注册
     * @param userBean
     * @return
     */
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

        String md5Password = DigestUtils.md5DigestAsHex(userBean1.getUserPsw().getBytes());
        Date date =new Date();
        userBean1.setUserPsw(md5Password);
        userBean1.setLastLoginTime(date);
        userBean1.setLastUpdateTime(date);
        userBean1.setCreateTime(date);
        int i = userMapper.insertSelective(userBean1);
       if (i>0){

       userBean1 =userMapper.selectOne(userBean1);

       }
     return  Result.success(userBean1);
    }

    /***
     * 修改用户信息
     * @param userBean
     * @return
     */
    @Override
    public Result<UserBean> setUserInformation(UserBean userBean) {
        // TODO: 2020/6/6 根据token判断用户是否登录


        // TODO: 2020/6/6 如果登录修改用户信息
        UserBean userBean1=new UserBean();
        userBean1.setLastUpdateTime(new Date());
        userBean1.setAvatar(userBean.getAvatar());
        userBean1.setBirthday(userBean.getBirthday());
        userBean1.setNickName(userBean.getNickName());
        userBean1.setSex(userBean.getSex());

        int i = userMapper.updateByPrimaryKey(userBean1);
        if (i>0){
            //修改成功获取详情存入缓存中




        }

        return null;
    }

    @Override
    public Result loginOut() {

        // TODO: 2020/6/6 通过头信息获取token 通过token清除缓存信息




        return Result.success("退出成功");
    }
}
