package com.xtwy.service.user.dao.impl;

import com.xtwy.common.core.dao.BaseDaoImpl;
import com.xtwy.facade.user.entity.SysUser;
import com.xtwy.service.user.dao.SysUserDao;
import org.springframework.stereotype.Repository;

/**
 * 类的描述：用户表数据访问层接口实现类
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  18:44
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
@Repository("SysUserDaoImpl")
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {
    /**
     * 根据用户登录名获取用户信息.
     * @param userNo
     * @return user .
     */
    public SysUser findByUserNo(String userNo) {
        //读取Mapper配置文件中id为findByUserNo
        return super.getSqlSession().selectOne(getStatement("findByUserNo"), userNo);
    }
    public static  void main(String args[]){
        SysUserDaoImpl s=new SysUserDaoImpl();
        System.out.print(s.getSessionTemplate());
    }

}
