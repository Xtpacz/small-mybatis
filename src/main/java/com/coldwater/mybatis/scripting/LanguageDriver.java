package com.coldwater.mybatis.scripting;

import com.coldwater.mybatis.executor.parameter.ParameterHandler;
import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.mapping.SqlSource;
import com.coldwater.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @author 小龙哥
 * @description 脚本语言驱动
 * @date 2024/5/17
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}
