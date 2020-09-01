package com.gitee.alona.boot.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Collection;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 18:50
 */
public interface AbstractMapper<D, E> {
    /**
     * DTO 转换成数据库的实体
     *
     * @param dto DTO
     * @return 数据库实体
     */
    E toEntity(D dto);

    /**
     * 数据库实体转换成 DTO
     *
     * @param entity 数据库
     * @return DTO
     */
    D toDto(E entity);

    /**
     * DTO 转换成数据库的实体
     *
     * @param dtoList DTO
     * @return 数据库实体
     */
    Collection<E> toEntity(Collection<D> dtoList);

    /**
     * 数据库实体转换成 DTO
     *
     * @param entityList 数据库
     * @return DTO
     */
    Collection<D> toDto(Collection<E> entityList);

    /**
     * 转换 分页的 entity 到 DTO
     *
     * @param page 查询出的分页
     * @return
     */
    default IPage<D> toDto(IPage<E> page) {
        return page.convert(this::toDto);
    }
}
