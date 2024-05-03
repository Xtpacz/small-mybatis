package com.coldwater.mybatis.session;

/**
 * @author 小龙哥
 * @description 工厂模式接口，构建SqlSession的工厂
 * @date 2024/04/01
  
 * @copyright 无
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}
