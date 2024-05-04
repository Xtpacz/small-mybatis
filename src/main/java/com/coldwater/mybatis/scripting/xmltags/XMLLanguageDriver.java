package com.coldwater.mybatis.scripting.xmltags;

import com.coldwater.mybatis.executor.parameter.ParameterHandler;
import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.mapping.SqlSource;
import com.coldwater.mybatis.scripting.LanguageDriver;
import com.coldwater.mybatis.scripting.defaults.DefaultParameterHandler;
import com.coldwater.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @author 小龙哥
 * @description XML语言驱动器
 * @date 2024/5/17
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}