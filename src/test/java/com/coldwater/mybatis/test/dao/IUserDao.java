package com.coldwater.mybatis.test.dao;

import com.coldwater.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long id);

    User queryUserInfo(User req);

}
