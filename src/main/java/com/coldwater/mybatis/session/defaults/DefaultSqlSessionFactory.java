package com.coldwater.mybatis.session.defaults;

import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.session.SqlSession;
import com.coldwater.mybatis.session.SqlSessionFactory;

/**
 * @author 小龙哥
 * @description 默认的 DefaultSqlSessionFactory
 * @date 2024/04/01
  
 * @copyright 无
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
