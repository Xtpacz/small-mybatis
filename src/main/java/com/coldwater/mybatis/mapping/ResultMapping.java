package com.coldwater.mybatis.mapping;

import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.type.JdbcType;
import com.coldwater.mybatis.type.TypeHandler;

/**
 * @author 小龙哥
 * @description 结果映射
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}
