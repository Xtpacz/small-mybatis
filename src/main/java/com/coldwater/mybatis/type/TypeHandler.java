package com.coldwater.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小龙哥
 * @description 类型处理器
 * @date 2024/5/17
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface TypeHandler<T> {

    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

}
