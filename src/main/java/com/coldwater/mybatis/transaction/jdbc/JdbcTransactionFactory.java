package com.coldwater.mybatis.transaction.jdbc;

import com.coldwater.mybatis.session.TransactionIsolationLevel;
import com.coldwater.mybatis.transaction.Transaction;
import com.coldwater.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author 小龙哥
 * @description JdbcTransaction 工厂
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
