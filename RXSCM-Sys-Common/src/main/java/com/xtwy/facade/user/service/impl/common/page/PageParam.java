package com.xtwy.facade.user.service.impl.common.page;

import java.io.Serializable;

/**
 * 类的描述：分页参数传递工具类
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  14:19
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public class PageParam implements Serializable {
    private static final long serialVersionUID = 6297178964005032338L;
    private int pageNum; // 当前页数
    private int numPerPage; // 每页记录数

    public PageParam(int pageNum, int numPerPage) {
        super();
        this.pageNum = pageNum;
        this.numPerPage = numPerPage;
    }
    /** 当前页数 */
    public int getPageNum() {
        return pageNum;
    }
    /** 当前页数 */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    /** 每页记录数 */
    public int getNumPerPage() {
        return numPerPage;
    }
    /** 每页记录数 */
    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }
}
