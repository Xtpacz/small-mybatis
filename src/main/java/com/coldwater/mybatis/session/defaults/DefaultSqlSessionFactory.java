package com.coldwater.mybatis.session.defaults;

import com.coldwater.mybatis.executor.Executor;
import com.coldwater.mybatis.mapping.Environment;
import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.session.SqlSession;
import com.coldwater.mybatis.session.SqlSessionFactory;
import com.coldwater.mybatis.session.TransactionIsolationLevel;
import com.coldwater.mybatis.transaction.Transaction;
import com.coldwater.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @author 小龙哥
 * @description 默认的 DefaultSqlSessionFactory
 * @date 2024/04/01
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }

}
