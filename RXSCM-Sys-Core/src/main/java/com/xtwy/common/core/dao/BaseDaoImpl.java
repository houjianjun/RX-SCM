package com.xtwy.common.core.dao;

import com.xtwy.facade.user.service.impl.common.entity.BaseEntity;
import com.xtwy.facade.user.service.impl.common.exceptions.BizException;
import com.xtwy.facade.user.service.impl.common.page.PageBean;
import com.xtwy.facade.user.service.impl.common.page.PageParam;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的描述：
 *
 * @作者: 侯建军
 * @邮箱: 474177818@qq.com
 * @博客: https://blog.csdn.net/marquis888
 * @创建日期: 2018年05月06日  17:47
 * @版本: v1.0
 * @jdk版本使用: JDK1.8
 */
public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    protected static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);

    public static final String SQL_INSERT = "insert";
    public static final String SQL_BATCH_INSERT = "batchInsert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_BATCH_UPDATE = "batchUpdate";
    public static final String SQL_GET_BY_ID = "getById";
    public static final String SQL_DELETE_BY_ID = "deleteById";
    public static final String SQL_LIST_PAGE = "listPage";
    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";
    public static final String SQL_LIST_BY = "listBy";
    // 根据当前分页参数进行统计
    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam";

    /**
     * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置).<br/>
     * 可以调用sessionTemplate完成数据库操作.
     */
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    @Autowired
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        //一定要设置给父类对象
        super.setSqlSessionTemplate(sessionTemplate);
        this.sessionTemplate = sessionTemplate;
    }
    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }
    /**
     * 保存对象.
     * @param entity .
     * @return id .
     */
    public long insert(T entity) {
        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
        }
        if (entity != null && entity.getId() != null && result > 0) {
            return entity.getId();
        }
        return result;
    }

    /**
     * 批量保存对象.
     *
     * @param list .
     * @return id .
     */
    public long insert(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
        }
        return result;
    }

    /**
     * 更新对象.
     * @param entity .
     * @return int .
     */
    public int update(T entity) {
        int result = sessionTemplate.update(getStatement(SQL_UPDATE), entity);
        if (result <= 0) {
            throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}", getStatement(SQL_UPDATE));
        }
        return result;
    }

    /**
     * 批量更新对象.
     * @param list .
     * @return int .
     */
    public int update(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int result = sessionTemplate.update(getStatement(SQL_BATCH_UPDATE), list);
        if (result <= 0) {
            throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}", getStatement(SQL_UPDATE));
        }
        return result;
    }
    /**
     * 根据ID查找对象.
     *
     * @param id .
     * @return T .
     */
    public T getById(long id) {
        return sessionTemplate.selectOne(getStatement(SQL_GET_BY_ID), id);
    }
    /**
     * 根据ID删除对象.
     *
     * @param id .
     * @return intNum .
     */
    public int deleteById(long id) {
        return (int) sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
    }
    /**
     * 分页查询 .
     * @param pageParam 分页参数.
     * @param paramMap  业务条件查询参数.
     * @return pageBean .
     */
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }
        // 根据页面传来的分页参数构造SQL分页参数
        paramMap.put("pageFirst", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize", pageParam.getNumPerPage());
        paramMap.put("startRowNum", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("endRowNum", pageParam.getPageNum() * pageParam.getNumPerPage());

        // 统计总记录数
        Long count = sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT), paramMap);

        // 获取分页数据集
        List<Object> list = sessionTemplate.selectList(getStatement(SQL_LIST_PAGE), paramMap);

        Object isCount = paramMap.get("isCount"); // 是否统计当前分页条件下的数据：1:是，其他为否
        if (isCount != null && "1".equals(isCount.toString())) {
            Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
            return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list, countResultMap);
        } else {
            // 构造分页对象
            return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
        }
    }

    /**
     * 根据条件查询 listBy: <br/>
     * @param paramMap
     * @return
     */
    public List<T> listBy(Map<String, Object> paramMap) {
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY), paramMap);
    }

    /**
     * 根据条件查询 getBy: selectOne <br/>
     * @param paramMap
     * @return
     */
    public T getBy(Map<String, Object> paramMap) {
        if (paramMap == null || paramMap.isEmpty()) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_LIST_BY), paramMap);
    }

    /**
     * 获取Mapper命名空间.
     * @param sqlId
     * @return
     */
    public String getStatement(String sqlId) {
        String name = this.getClass().getName();
        StringBuffer sb = new StringBuffer();
        sb.append(name).append(".").append(sqlId);
        String statement = sb.toString();
        return statement;
    }
}