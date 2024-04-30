package com.coldwater.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @description 映射器代理工厂
 */
public class MapperProxyFactory<T> {

    // 映射器接口,,给哪个接口做代理
    private final Class<T> mapperInterface;

    // 构造方法，传入映射器接口
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    // 给接口生成代理对象
    public T newInstance(Map<String, String> sqlSession) {
        // 创建代理对象，传入 sqlSession 和  接口
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        // 返回代理对象
        return (T) Proxy.newProxyInstance(
                mapperInterface.getClassLoader(), // 类加载器
                new Class[]{mapperInterface},  // 被代理类实现的一些接口
                mapperProxy // 实现了接口的对象
        );
    }

}
