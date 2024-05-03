package com.coldwater.mybatis.session.defaults;

import com.coldwater.mybatis.session.Configuration;
import com.coldwater.mybatis.session.SqlSession;
import com.coldwater.mybatis.session.SqlSessionFactory;

/**
 * @author 小傅哥，微信：fustack
 * @description 默认的 DefaultSqlSessionFactory
 * @date 2022/04/01
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
