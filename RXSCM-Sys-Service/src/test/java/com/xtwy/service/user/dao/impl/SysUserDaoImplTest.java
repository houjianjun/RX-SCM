package com.xtwy.service.user.dao.impl;

import com.xtwy.facade.user.entity.SysUser;
import com.xtwy.service.user.biz.SysUserBiz;
import com.xtwy.service.user.dao.SysUserDao;
import com.xtwy.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类的描述：
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  20:17
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public class SysUserDaoImplTest extends BaseTest {
    @Autowired
    private SysUserDao sud;


    @Test
    public void testFindByUserNo() {

    }

    @Test
    public void testInsert() {
        SysUser entity = new SysUser();
        entity.setMobileNo("13888888888");
        entity.setUserName("侯建军");
        long id = sud.insert(entity);
        Assert.assertTrue(id > 0);
    }
}