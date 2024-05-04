package com.coldwater.mybatis.scripting.xmltags;

/**
 * @author 小龙哥
 * @description SQL 节点
 * 
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface SqlNode {

    boolean apply(DynamicContext context);

}