package com.coldwater.mybatis.scripting;

import com.coldwater.mybatis.mapping.SqlSource;
import com.coldwater.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @author 小龙哥
 * @description 脚本语言驱动
 * @date 2024/5/17
 * @github https://github.com/xtpacz
 * @Copyright 无copyright
 */
public interface LanguageDriver {

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}
