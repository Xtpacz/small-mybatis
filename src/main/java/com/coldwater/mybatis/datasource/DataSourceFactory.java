package com.coldwater.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 小龙哥
 * @description 数据源工厂
 * @date 2024/04/13
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
