package com.coldwater.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 小龙哥
 * @description 结果集处理器
 * @date 2024/04/26
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement stmt) throws SQLException;

}
