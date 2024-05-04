package com.coldwater.mybatis.reflection.wrapper;

import com.coldwater.mybatis.reflection.MetaObject;

/**
 * @author 小龙哥
 * @description 默认对象包装工厂
 * @date 2024/5/2
 * @github https://github.com/xtpacz/CodeDesignTutorials
 * @Copyright 无copyright
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }

}
