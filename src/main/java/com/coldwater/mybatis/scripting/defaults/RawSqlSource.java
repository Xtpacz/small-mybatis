package com.coldwater.mybatis.scripting.defaults;

import com.coldwater.mybatis.builder.SqlSourceBuilder;
import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.SqlSource;
import com.coldwater.mybatis.scripting.xmltags.DynamicContext;
import com.coldwater.mybatis.scripting.xmltags.SqlNode;
import com.coldwater.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * @author 小龙哥
 * @description 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }

}
