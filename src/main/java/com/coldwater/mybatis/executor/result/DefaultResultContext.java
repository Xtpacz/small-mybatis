package com.coldwater.mybatis.executor.result;

import com.coldwater.mybatis.session.ResultContext;

/**
 * @author 小龙哥
 * @description 默认结果上下文
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }

}
