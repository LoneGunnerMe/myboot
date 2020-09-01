package com.gitee.alona.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gitee.alona.boot.mapper.AbstractMapper;

import java.io.Serializable;
import java.util.Collection;

/**
 * 抽象的 service
 *
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 21:12
 */
public interface BaseService<D, E, M extends AbstractMapper<D, E>> extends IService<E> {

    /**
     * 创建对象
     *
     * @param d DTO
     * @return 带 id 的 DTO
     */
    D create(D d);

    /**
     * 根据 id 获取对象
     *
     * @param id 对象的 id
     * @return DTO
     */
    D get(Serializable id);

    /**
     * 更新
     *
     * @param d 更新的对象
     * @return 是否成功
     */
    boolean update(D d);

    /**
     * 分页查询
     *
     * @param d          DTO
     * @param pageNumber 页码
     * @param pageSize   每一页数据的大小
     * @return
     */
    IPage<D> findPage(D d, int pageNumber, int pageSize);

    /**
     * 删除
     *
     * @param id 主键 id
     * @return 删除结果
     */
    boolean delete(Serializable id);

    /**
     * 批量删除
     *
     * @param ids id 集合
     * @return 删除结果
     */
    boolean delete(Collection<? extends Serializable> ids);

}
