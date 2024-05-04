package com.coldwater.mybatis.mapping;

/**
 * @author 小龙哥
 * @description SQL源码
 * @date 2024/5/17
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
