package com.coldwater.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author 小龙哥
 * @description getter 调用者
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public class GetFieldInvoker implements Invoker {

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }

}
