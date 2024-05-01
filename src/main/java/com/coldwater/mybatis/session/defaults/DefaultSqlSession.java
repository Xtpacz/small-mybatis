package com.coldwater.mybatis.session.defaults;

import com.coldwater.mybatis.binding.MapperRegistry;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.session.SqlSession;

/**
 * @description 默认SqlSession实现类
 * @author：小龙哥
 * @date: 2024/4/30
 * @Copyright： 没有copyright
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
