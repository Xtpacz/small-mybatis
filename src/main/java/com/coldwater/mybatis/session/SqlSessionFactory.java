package com.coldwater.mybatis.session;

/**
 * @description 工厂模式接口，构建SqlSession的工厂
 * @author：小龙哥
 * @date: 2024/4/30
 * @Copyright： 没有copyright
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}
