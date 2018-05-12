package com.xtwy;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类的描述：启动Dubbo服务用的MainClass.
 * Dubbo服务提供者
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月10日  19:57
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public class DubboProvider {
    //日志管理
    private static final Log log = LogFactory.getLog(DubboProvider.class);
    public static  void main(String[] args){
          try {
            //加载Spring配置文件
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
            //启动上下文
            context.start();
        } catch (Exception e) {
            log.error("== DubboProvider context start error:",e);
        }
        synchronized (DubboProvider.class) {
            while (true) {
                try {
                    DubboProvider.class.wait();
                } catch (InterruptedException e) {
                    log.error("== synchronized error:",e);
                }
            }
        }
    }
}
