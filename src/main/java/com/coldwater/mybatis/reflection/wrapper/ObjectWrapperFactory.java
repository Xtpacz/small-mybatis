package com.coldwater.mybatis.reflection.wrapper;

import com.coldwater.mybatis.reflection.MetaObject;

/**
 * @author 小龙哥
 * @description 对象包装工厂
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
