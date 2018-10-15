package com.luanrubensf.springquerygql.core.pagination;

import java.util.List;

public class Page<T> {

    private Integer limit;
    private Long offset;
    private Long total;
    private boolean hasNext;
    private List<T> content;

    protected Page(Integer limit, Long offset, Long total, List<T> content) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.content = content;
    }

    public Page(Integer limit, Long offset, boolean hasNext, List<T> content) {
        this.limit = limit;
        this.offset = offset;
        this.hasNext = hasNext;
        this.content = content;
    }

    public Page(Integer limit, Long offset, Long total, boolean hasNext, List<T> content) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.hasNext = hasNext;
        this.content = content;
    }

    public Integer getLimit() {
        return limit;
    }

    public Long getOffset() {
        return offset;
    }

    public Long getTotal() {
        return total;
    }

    public boolean hasNext() {
        return hasNext;
    }

    public List<T> getContent() {
        return content;
    }

    public static <T> Page<T> of(Integer limit, Long offset, Long total, List<T> content) {
        return new Page<>(limit, offset, total, content);
    }

    public static <T> Page<T> of(Integer limit, Long offset, boolean hasNext, List<T> content) {
        return new Page<>(limit, offset, hasNext, content);
    }

    public static <T> Page<T> of(Integer limit, Long offset, Long total, boolean hasNext, List<T> content) {
        return new Page<>(limit, offset, total, hasNext, content);
    }
}
