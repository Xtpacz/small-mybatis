package com.coldwater.mybatis.test.dao;

/**
 * @description
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

}
