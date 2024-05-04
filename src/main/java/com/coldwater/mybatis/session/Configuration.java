package com.coldwater.mybatis.session;

import com.coldwater.mybatis.binding.MapperRegistry;
import com.coldwater.mybatis.datasource.druid.DruidDataSourceFactory;
import com.coldwater.mybatis.datasource.pooled.PooledDataSourceFactory;
import com.coldwater.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import com.coldwater.mybatis.executor.Executor;
import com.coldwater.mybatis.executor.SimpleExecutor;
import com.coldwater.mybatis.executor.parameter.ParameterHandler;
import com.coldwater.mybatis.executor.resultset.DefaultResultSetHandler;
import com.coldwater.mybatis.executor.resultset.ResultSetHandler;
import com.coldwater.mybatis.executor.statement.PreparedStatementHandler;
import com.coldwater.mybatis.executor.statement.StatementHandler;
import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.Environment;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.reflection.MetaObject;
import com.coldwater.mybatis.reflection.factory.DefaultObjectFactory;
import com.coldwater.mybatis.reflection.factory.ObjectFactory;
import com.coldwater.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import com.coldwater.mybatis.reflection.wrapper.ObjectWrapperFactory;
import com.coldwater.mybatis.scripting.LanguageDriver;
import com.coldwater.mybatis.scripting.LanguageDriverRegistry;
import com.coldwater.mybatis.scripting.xmltags.XMLLanguageDriver;
import com.coldwater.mybatis.transaction.Transaction;
import com.coldwater.mybatis.transaction.jdbc.JdbcTransactionFactory;
import com.coldwater.mybatis.type.TypeAliasRegistry;
import com.coldwater.mybatis.type.TypeHandlerRegistry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 小龙哥
 * @description 配置项
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class Configuration {

    //环境
    protected Environment environment;

    // 映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
    protected final LanguageDriverRegistry languageRegistry = new LanguageDriverRegistry();

    // 类型处理器注册机
    protected final TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry();

    // 对象工厂和对象包装器工厂
    protected ObjectFactory objectFactory = new DefaultObjectFactory();
    protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();

    protected final Set<String> loadedResources = new HashSet<>();

    protected String databaseId;

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);

        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);

        languageRegistry.setDefaultDriverClass(XMLLanguageDriver.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    /**
     * 创建结果集处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, resultHandler, rowBounds, boundSql);
    }

    /**
     * 生产执行器
     */
    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor(this, transaction);
    }

    /**
     * 创建语句处理器
     */
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameter, rowBounds, resultHandler, boundSql);
    }

    // 创建元对象
    public MetaObject newMetaObject(Object object) {
        return MetaObject.forObject(object, objectFactory, objectWrapperFactory);
    }

    // 类型处理器注册机
    public TypeHandlerRegistry getTypeHandlerRegistry() {
        return typeHandlerRegistry;
    }

    public boolean isResourceLoaded(String resource) {
        return loadedResources.contains(resource);
    }

    public void addLoadedResource(String resource) {
        loadedResources.add(resource);
    }

    public LanguageDriverRegistry getLanguageRegistry() {
        return languageRegistry;
    }

    public ParameterHandler newParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        // 创建参数处理器
        ParameterHandler parameterHandler = mappedStatement.getLang().createParameterHandler(mappedStatement, parameterObject, boundSql);
        // 插件的一些参数，也是在这里处理，暂时不添加这部分内容 interceptorChain.pluginAll(parameterHandler);
        return parameterHandler;
    }

    public LanguageDriver getDefaultScriptingLanguageInstance() {
        return languageRegistry.getDefaultDriver();
    }

    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

}
