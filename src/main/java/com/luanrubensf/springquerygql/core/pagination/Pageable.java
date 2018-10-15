package com.luanrubensf.springquerygql.core.pagination;

public class Pageable {

    private static final long DEFAULT_OFFSET = 0;
    private static final int ZERO = 0;
    private static final int DEFAULT_LIMIT = 10;

    private Integer limit;
    private Long offset;

    protected Pageable(Integer limit, Long offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public static Pageable of(Integer limit, Long offset) {
        if (limit == null || limit == ZERO) {
            limit = DEFAULT_LIMIT;
        }
        if (offset == null) {
            offset = DEFAULT_OFFSET;
        }
        return new Pageable(limit, offset);
    }

    public Integer getLimit() {
        return limit;
    }

    public Long getOffset() {
        return offset;
    }
}
