package com.coldwater.mybatis.executor;

import com.coldwater.mybatis.executor.statement.StatementHandler;
import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.session.ResultHandler;
import com.coldwater.mybatis.session.RowBounds;
import com.coldwater.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 小龙哥
 * @description 简单执行器
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class SimpleExecutor extends BaseExecutor {

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        try {
            Configuration configuration = ms.getConfiguration();
            // 新建一个 StatementHandler
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, rowBounds, resultHandler, boundSql);
            Connection connection = transaction.getConnection();
            // 准备语句
            Statement stmt = handler.prepare(connection);
            handler.parameterize(stmt);
            // 返回结果
            return handler.query(stmt, resultHandler);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
