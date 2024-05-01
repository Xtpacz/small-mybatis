package com.coldwater.mybatis.builder;

import com.coldwater.mybatis.session.Configuration;

/**
 * @description 构建器的基类，建造者模式
 * @author：小龙哥
 * @date: 2024/5/1
 * @Copyright： 没有copyright
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
