package com.coldwater.mybatis.builder;

import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.type.TypeAliasRegistry;

/**
 * @author 小龙哥
 * @description 构建器的基类，建造者模式
 * @date 2024/04/06
  
 * @copyright 无
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
