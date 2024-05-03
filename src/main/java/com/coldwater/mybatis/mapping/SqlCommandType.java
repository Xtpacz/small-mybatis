package com.coldwater.mybatis.mapping;

/**
 * @author 小龙哥
 * @description SQL 指令类型
 * @date 2024/04/06
  
 * @copyright 无
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
