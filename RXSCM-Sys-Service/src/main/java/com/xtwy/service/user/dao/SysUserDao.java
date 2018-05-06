package com.xtwy.service.user.dao;

import com.xtwy.common.core.dao.BaseDao;
import com.xtwy.facade.user.entity.SysUser;

/**
 * 类的描述：
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  18:37
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public interface SysUserDao  extends BaseDao<SysUser> {
    /**
     * 根据用户登录名获取用户信息.
     *
     * @param userNo
     *            .
     * @return user .
     */
    SysUser findByUserNo(String userNo);

}
