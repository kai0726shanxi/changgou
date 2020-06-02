package com.changgou.user.entity;

/*
 *功能描述
 * @author gao
 * @date 2020-06-10
 * @description 用户实体类$
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "user_info")
public class UserBean {
    /***
     * 主键自增
     */
    @Id
    @Column(name = "user_id")
    private Long userId;
    /***
     * 账户
     */
    @Column(name = "user_account")
    private String userAccount;


    /***
     * 密码
     */
    @Column(name = "user_psw")
    private String userPsw;


    private String avatar;
    /***
     * 性别 1-男 2-女
     */
    private Integer sex;


    /***
     * 生日
     */
    private String birthday;


    /***
     * 用户类型 0-普通 1-授权 2-管理
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
   private Date lastUpdateTime;
    /**
     * 最后更新时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /***
     * 邀请码
     */
    @Column(name = "invite_code")
    private String inviteCode;

}
