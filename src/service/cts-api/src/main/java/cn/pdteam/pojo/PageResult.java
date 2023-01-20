package cn.pdteam.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    /**
     * 总数目
     */
    private Integer totalCount;
    /**
     * 每页的条目数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 当前页数
     */
    private Integer curPage;
    /**
     * 当前页的条目
     */
    private List<T> list;

    public PageResult(Integer totalCount, Integer pageSize, Integer curPage, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageCount = (int) Math.ceil((double) totalCount / pageSize);
        this.curPage = curPage;
        this.list = list;
    }
}
