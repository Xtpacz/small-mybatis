package com.coldwater.mybatis.binding;

import com.coldwater.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @description 映射器代理工厂
 * @author：小龙哥
 * @date: 2024/4/30
 * @Copyright： 没有copyright
 */
public class MapperProxyFactory<T> {

    // 映射器接口,,给哪个接口做代理
    private final Class<T> mapperInterface;

    // 构造方法，传入映射器接口
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    // 给接口生成代理对象
    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(
                mapperInterface.getClassLoader(),
                new Class[]{mapperInterface},
                mapperProxy
        );
    }

}
