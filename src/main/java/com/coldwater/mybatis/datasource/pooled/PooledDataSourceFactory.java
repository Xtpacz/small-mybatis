package com.coldwater.mybatis.datasource.pooled;

import com.coldwater.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @author 小龙哥
 * @description 有连接池的数据源工厂
 * @date 2024/04/22
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
