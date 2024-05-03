package com.coldwater.mybatis.session;

import com.coldwater.mybatis.builder.xml.XMLConfigBuilder;
import com.coldwater.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author 小龙哥
 * @description 构建SqlSessionFactory的工厂
 * @date 2024/04/06
  
 * @copyright 无
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
