package com.coldwater.mybatis.executor.statement;

import com.coldwater.mybatis.executor.Executor;
import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.session.ResultHandler;
import com.coldwater.mybatis.session.RowBounds;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 小龙哥
 * @description 简单语句处理器（STATEMENT）
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class SimpleStatementHandler extends BaseStatementHandler {

    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, rowBounds, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // N/A
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }

}
