package com.coldwater.mybatis.transaction;

import com.coldwater.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author 小龙哥
 * @description 事务工厂
 * @date 2024/04/13
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public interface TransactionFactory {

    /**
     * 根据 Connection 创建 Transaction
     * @param conn Existing database connection
     * @return Transaction
     */
    Transaction newTransaction(Connection conn);

    /**
     * 根据数据源和事务隔离级别创建 Transaction
     * @param dataSource DataSource to take the connection from
     * @param level Desired isolation level
     * @param autoCommit Desired autocommit
     * @return Transaction
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}
