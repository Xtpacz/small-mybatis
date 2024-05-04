package com.coldwater.mybatis.builder;

import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.ParameterMapping;
import com.coldwater.mybatis.mapping.SqlSource;
import com.coldwater.mybatis.session.Configuration;

import java.util.List;

/**
 * @author 小龙哥
 * @description 静态SQL源码
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }

}
