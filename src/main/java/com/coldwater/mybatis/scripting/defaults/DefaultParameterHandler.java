package com.coldwater.mybatis.scripting.defaults;

import com.coldwater.mybatis.executor.parameter.ParameterHandler;
import com.coldwater.mybatis.mapping.BoundSql;
import com.coldwater.mybatis.mapping.MappedStatement;
import com.coldwater.mybatis.mapping.ParameterMapping;
import com.coldwater.mybatis.reflection.MetaObject;
import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.type.JdbcType;
import com.coldwater.mybatis.type.TypeHandler;
import com.coldwater.mybatis.type.TypeHandlerRegistry;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 小龙哥
 * @description 默认参数处理器
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public class DefaultParameterHandler implements ParameterHandler {

    private Logger logger = LoggerFactory.getLogger(DefaultParameterHandler.class);

    private final TypeHandlerRegistry typeHandlerRegistry;

    private final MappedStatement mappedStatement;
    private final Object parameterObject;
    private BoundSql boundSql;
    private Configuration configuration;

    public DefaultParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        this.mappedStatement = mappedStatement;
        this.configuration = mappedStatement.getConfiguration();
        this.typeHandlerRegistry = mappedStatement.getConfiguration().getTypeHandlerRegistry();
        this.parameterObject = parameterObject;
        this.boundSql = boundSql;
    }

    @Override
    public Object getParameterObject() {
        return parameterObject;
    }

    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (null != parameterMappings) {
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                String propertyName = parameterMapping.getProperty();
                Object value;
                if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                    value = parameterObject;
                } else {
                    // 通过 MetaObject.getValue 反射取得值设进去
                    MetaObject metaObject = configuration.newMetaObject(parameterObject);
                    value = metaObject.getValue(propertyName);
                }
                JdbcType jdbcType = parameterMapping.getJdbcType();

                // 设置参数
                logger.info("根据每个ParameterMapping中的TypeHandler设置对应的参数信息 value：{}", JSON.toJSONString(value));
                TypeHandler typeHandler = parameterMapping.getTypeHandler();
                typeHandler.setParameter(ps, i + 1, value, jdbcType);
            }
        }
    }

}
