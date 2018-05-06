package com.xtwy.common.core.dao;

import com.xtwy.facade.user.service.impl.common.page.PageBean;
import com.xtwy.facade.user.service.impl.common.page.PageParam;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * 类的描述：
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  14:08
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public interface BaseDao<T> {
    /**
     * 根据实体对象新增记录.
     *
     * @param entity
     *            .
     * @return id .
     */
    long insert(T entity);

    /**
     * 批量保存对象.
     *
     * @param list
     *            .
     * @return id .
     */
    long insert(List<T> list);

    /**
     * 更新实体对应的记录.
     *
     * @param entity
     *            .
     * @return
     */
    int update(T entity);

    /**
     * 批量更新对象.
     *
     * @param list
     *            .
     * @return int .
     */
    int update(List<T> list);

    /**
     * 根据ID查找记录.
     *
     * @param id
     *            .
     * @return entity .
     */
    T getById(long id);

    /**
     * 根据ID删除记录.
     *
     * @param id
     *            .
     * @return
     */
    int deleteById(long id);

    /**
     * 分页查询 .
     *
     * @param pageParam
     *            分页参数.
     * @param paramMap
     *            业务条件查询参数.
     * @return
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    /**
     * 根据条件查询 listBy: <br/>
     *
     * @param paramMap
     * @return 返回集合
     */
    public List<T> listBy(Map<String, Object> paramMap);

    /**
     * 根据条件查询 listBy: <br/>
     *
     * @param paramMap
     * @return 返回实体
     */
    public T getBy(Map<String, Object> paramMap);

    public SqlSessionTemplate getSessionTemplate();

    public SqlSession getSqlSession();
}
