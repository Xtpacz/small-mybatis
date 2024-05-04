package com.coldwater.mybatis.reflection.invoker;

import java.lang.reflect.Method;

/**
 * @author 小龙哥
 * @description 方法调用者
 * @date 2024/5/2
 * @github https://github.com/xtpacz/CodeDesignTutorials
 * @Copyright 无copyright
 */
public class MethodInvoker implements Invoker {

    private Class<?> type;
    private Method method;

    public MethodInvoker(Method method) {
        this.method = method;

        // 如果只有一个参数，返回参数类型，否则返回 return 类型
        if (method.getParameterTypes().length == 1) {
            type = method.getParameterTypes()[0];
        } else {
            type = method.getReturnType();
        }
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return method.invoke(target, args);
    }

    @Override
    public Class<?> getType() {
        return type;
    }

}
