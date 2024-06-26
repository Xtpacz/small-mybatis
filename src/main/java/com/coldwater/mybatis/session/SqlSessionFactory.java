package com.coldwater.mybatis.session;

/**
 * @author 小龙哥
 * @description 工厂模式接口，构建SqlSession的工厂
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}
