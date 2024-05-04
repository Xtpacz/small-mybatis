package com.coldwater.mybatis.mapping;

/**
 * @author 小龙哥
 * @description SQL源码
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
