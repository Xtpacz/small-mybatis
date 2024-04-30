package com.coldwater.mybatis.test;

import com.coldwater.mybatis.binding.MapperRegistry;
import com.coldwater.mybatis.session.SqlSession;
import com.coldwater.mybatis.test.dao.IUserDao;
import com.coldwater.mybatis.session.SqlSessionFactory;
import com.coldwater.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.coldwater.mybatis.test.no.IFakeDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * @description 单元测试
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                // 类加载器,用于加载代理类的字节码
                Thread.currentThread().getContextClassLoader(),
                // 代理类需要实现的接口，至少需要一个接口，否则报错
                new Class[]{IUserDao.class},
                // 方法调用处理器，当代理对象的方法被调用时，会触发执行处理器的方法
                (proxy, method, args) -> "你被代理了！");
        String result = userDao.queryUserName("10001");
        logger.info("测试结果：{}", result);
    }

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.coldwater.mybatis.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 这个执行不通，因为没有将其路径交给注册机去扫描！
//        IFakeDao fakeDao = sqlSession.getMapper(IFakeDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }

}