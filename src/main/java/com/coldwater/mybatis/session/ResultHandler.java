package com.coldwater.mybatis.session;

/**
 * @author 小龙哥
 * @description 结果处理器
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public interface ResultHandler {

    /**
     * 处理结果
     */
    void handleResult(ResultContext context);

}
