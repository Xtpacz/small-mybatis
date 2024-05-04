package com.coldwater.mybatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小龙哥
 * @description 参数处理器
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface ParameterHandler {

    /**
     * 获取参数
     */
    Object getParameterObject();

    /**
     * 设置参数
     */
    void setParameters(PreparedStatement ps) throws SQLException;

}
