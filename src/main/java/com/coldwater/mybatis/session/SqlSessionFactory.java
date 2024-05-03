package com.coldwater.mybatis.session;

/**
 * @description 工厂模式接口，构建SqlSession的工厂
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}
