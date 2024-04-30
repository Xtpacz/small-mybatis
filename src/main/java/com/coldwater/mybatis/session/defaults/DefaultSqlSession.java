package com.coldwater.mybatis.session.defaults;

import com.coldwater.mybatis.binding.MapperRegistry;
import com.coldwater.mybatis.session.SqlSession;

/**
 * @description 默认SqlSession实现类
 * @author：小龙哥
 * @date: 2024/4/30
 * @Copyright： 没有copyright
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }

}
