package com.coldwater.mybatis.executor.result;

import com.coldwater.mybatis.reflection.factory.ObjectFactory;
import com.coldwater.mybatis.session.ResultContext;
import com.coldwater.mybatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小龙哥
 * @description 默认结果处理器
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class DefaultResultHandler implements ResultHandler {

    private final List<Object> list;

    public DefaultResultHandler() {
        this.list = new ArrayList<>();
    }

    /**
     * 通过 ObjectFactory 反射工具类，产生特定的 List
     */
    public DefaultResultHandler(ObjectFactory objectFactory) {
        this.list = objectFactory.create(List.class);
    }

    @Override
    public void handleResult(ResultContext context) {
        list.add(context.getResultObject());
    }

    public List<Object> getResultList() {
        return list;
    }

}
