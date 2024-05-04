package com.coldwater.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小龙哥
 * @description String类型处理器
 * @date 2024/5/25
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public class StringTypeHandler extends BaseTypeHandler<String>{

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);
    }

}
