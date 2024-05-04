package com.coldwater.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author 小龙哥
 * @description setter 调用者
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public class SetFieldInvoker implements Invoker {

    private Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target, args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }

}