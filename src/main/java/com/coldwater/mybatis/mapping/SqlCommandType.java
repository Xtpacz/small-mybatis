package com.coldwater.mybatis.mapping;

/**
 * @description SQL 指令类型
 * @author：小龙哥
 * @date: 2024/5/1
 * @Copyright： 没有copyright
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
