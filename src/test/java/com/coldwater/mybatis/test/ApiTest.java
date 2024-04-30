package com.coldwater.mybatis.test;

import com.coldwater.mybatis.binding.MapperProxyFactory;
import com.coldwater.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @description 单元测试
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        // 模拟sqlSession
        Map<String, String> sqlSession = new HashMap<>();
        // 接口全限名 ： 就是接口的绝对路径名称，包括接口所在的包名和接口的名称

        // 通过 接口全限名+方法名作为 key，  随便创建一个字符串作为value   来模拟 sqlSession 的操作
        sqlSession.put("com.coldwater.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.coldwater.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        // userDao: cn.bugstack.mybatis.binding.MapperProxy@2eda0940
        IUserDao userDao = factory.newInstance(sqlSession);

        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }


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
//        logger.info("测试结果：{}", JSON.toJSONString(result));
        logger.info("测试结果：{}", result);
//        System.out.println("测试结果：" + result);
    }

}