package com.coldwater.mybatis.reflection.invoker;

/**
 * @author 小龙哥
 * @description 调用者
 * @date 2024/5/2
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
