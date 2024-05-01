package com.coldwater.mybatis.test;

import com.coldwater.mybatis.io.Resources;
import com.coldwater.mybatis.session.SqlSession;
import com.coldwater.mybatis.session.SqlSessionFactory;
import com.coldwater.mybatis.session.SqlSessionFactoryBuilder;
import com.coldwater.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @description 单元测试
 * @author：小龙哥
 * @date: 2024/5/1
 * @Copyright： 没有copyright
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象，，代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }

}
