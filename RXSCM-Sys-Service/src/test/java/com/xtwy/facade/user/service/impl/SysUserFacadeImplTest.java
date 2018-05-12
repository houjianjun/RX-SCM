package com.xtwy.facade.user.service.impl;

import com.xtwy.facade.user.entity.SysUser;
import com.xtwy.facade.user.service.SysUserFacade;
import com.xtwy.service.user.dao.SysUserDao;
import com.xtwy.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 类的描述：
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月11日  21:38
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public class SysUserFacadeImplTest  extends BaseTest {
    @Autowired
    private SysUserFacade suf;
    @Test
    public void testCreate(){
        SysUser entity = new SysUser();
        entity.setMobileNo("13888888888");
        entity.setUserName("侯建军");
        suf.create(entity);
    }
}