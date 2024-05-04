package com.coldwater.mybatis.reflection.wrapper;

import com.coldwater.mybatis.reflection.MetaObject;

/**
 * @author 小龙哥
 * @description 对象包装工厂
 * @date 2024/5/2
 * @github https://github.com/xtpacz/CodeDesignTutorials
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
