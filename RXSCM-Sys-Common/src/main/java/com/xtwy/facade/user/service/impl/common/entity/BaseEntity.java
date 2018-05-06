package com.xtwy.facade.user.service.impl.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类的描述：
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  13:56
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键ID **/
    private Long id;

    /** 版本号 **/
    private Integer version = 0;

    /** 创建时间 **/
    private Date createTime;


    /** 主键ID **/
    public Long getId() {
        return id;
    }

    /** 主键ID **/
    public void setId(Long id) {
        this.id = id;
    }

    /** 版本号 **/
    public Integer getVersion() {
        return version;
    }

    /** 版本号 **/
    public void setVersion(Integer version) {
        this.version = version;
    }

    /** 创建时间 **/
    public Date getCreateTime() {
        return createTime;
    }

    /** 创建时间 **/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
