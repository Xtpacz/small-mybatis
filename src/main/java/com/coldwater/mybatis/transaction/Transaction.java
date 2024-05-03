package com.coldwater.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 小龙哥
 * @description 事务接口
 * @date 2024/04/13
  
 * @copyright 无
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;

}
