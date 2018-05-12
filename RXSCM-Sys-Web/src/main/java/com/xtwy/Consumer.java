package com.xtwy;

import com.xtwy.facade.user.entity.SysUser;
import com.xtwy.facade.user.service.SysUserFacade;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类的描述：
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月11日  8:23
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //配置文件地址
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        SysUserFacade sud = (SysUserFacade)context.getBean("sysUserFacade"); // 获取远程服务代理

        SysUser entity = new SysUser();
        entity.setMobileNo("13888888888");
        entity.setUserName("侯建军0");
        // 执行远程方法
        long id = sud.create(entity);
        // 显示调用结果
        System.out.println(id+"已获取到对象");
    }
}
