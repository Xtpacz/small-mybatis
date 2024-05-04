package com.coldwater.mybatis.builder;

import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.type.TypeAliasRegistry;
import com.coldwater.mybatis.type.TypeHandlerRegistry;

/**
 * @author 小龙哥
 * @description 构建器的基类，建造者模式
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;
    protected final TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }
}
