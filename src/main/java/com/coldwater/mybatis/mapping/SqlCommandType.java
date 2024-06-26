package com.coldwater.mybatis.mapping;

/**
 * @author 小龙哥
 * @description SQL 指令类型
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
