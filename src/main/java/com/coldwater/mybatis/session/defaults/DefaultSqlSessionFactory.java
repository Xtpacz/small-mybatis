package com.coldwater.mybatis.session.defaults;

import com.coldwater.mybatis.binding.MapperRegistry;
import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.session.SqlSession;
import com.coldwater.mybatis.session.SqlSessionFactory;

/**
 * @description 默认的 DefaultSqlSessionFactory
 * @author：小龙哥
 * @date: 2024/4/30
 * @Copyright： 没有copyright
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
