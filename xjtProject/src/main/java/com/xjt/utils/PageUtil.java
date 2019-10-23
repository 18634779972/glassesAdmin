package com.xjt.utils;

public class PageUtil {

    /**
     * 判断有没有下一页,总记录数，每页请求量，当前页，
     */
    public static Boolean isNext(Integer totalCount, Integer pageSize, Integer pageNo) {
        Boolean next = false;
        //计算总页数
        Integer totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        if (pageNo < totalPage) {
            next = true;
        }

        return next;
    }

    /**
     * 计算总页数
     */
    public static Integer totalPage(Integer totalCount, Integer pageSize) {
        Integer totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        return totalPage;
    }
}
