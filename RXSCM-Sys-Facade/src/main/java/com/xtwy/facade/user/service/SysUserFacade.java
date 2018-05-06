package com.xtwy.facade.user.service;

import com.xtwy.facade.user.entity.SysUser;
import com.xtwy.facade.user.service.impl.common.page.PageBean;
import com.xtwy.facade.user.service.impl.common.page.PageParam;

import java.util.Map;

/**
 * 类的描述：用户Dubbo服务接口
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  18:26
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public interface SysUserFacade {
    /**
     * 保存用户信息.
     *
     * @param sysUser
     */
    public void create(SysUser sysUser);

    /**
     * 根据ID获取用户信息.
     *
     * @param userId
     * @return
     */
    public SysUser getById(Long userId);

    /**
     * 根据登录名取得用户对象
     */
    public SysUser findUserByUserNo(String userNo);

    /**
     * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
     *
     * @param userId 用户ID.
     */
    public void deleteUserById(long userId);


    /**
     * 更新用户信息.
     *
     * @param user
     */
    public void update(SysUser user);

    /**
     * 根据用户ID更新用户密码.
     *
     * @param userId
     * @param newPwd (已进行SHA1加密)
     */
    public void updateUserPwd(Long userId, String newPwd, boolean isTrue);

    /**
     * 查询并分页列出用户信息.
     *
     * @param pageParam
     * @param paramMap
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
}
