package com.coldwater.mybatis.session;

/**
 * @author 小龙哥
 * @description 结果上下文
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();

}
