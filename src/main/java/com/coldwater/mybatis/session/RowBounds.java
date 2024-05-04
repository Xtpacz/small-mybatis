package com.coldwater.mybatis.session;

/**
 * @author 小龙哥
 * @description 分页记录限制
 * 
 * @github https://github.com/xtpacz
 * @copyright 无copyright
 */
public class RowBounds {

    public static final int NO_ROW_OFFSET = 0;
    public static final int NO_ROW_LIMIT = Integer.MAX_VALUE;
    public static final RowBounds DEFAULT = new RowBounds();

    // offset,limit就等于一般分页的start,limit,
    private int offset;
    private int limit;

    // 默认是一页Integer.MAX_VALUE条
    public RowBounds() {
        this.offset = NO_ROW_OFFSET;
        this.limit = NO_ROW_LIMIT;
    }

    public RowBounds(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }


}
