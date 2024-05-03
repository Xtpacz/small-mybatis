package com.coldwater.mybatis.executor;

import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.session.ResultHandler;
import com.coldwater.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 小龙哥
 * @description 执行器
 * @date 2024/04/26
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}