package com.gitee.alona.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gitee.alona.boot.mapper.AbstractMapper;
import com.gitee.alona.boot.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 21:20
 */
public abstract class AbstractServiceImpl<D, E, M extends AbstractMapper<D, E>, DAO extends BaseMapper<E>> extends ServiceImpl<DAO, E> implements BaseService<D, E, M> {
    @Autowired
    protected BaseMapper<E> dao;
    @Autowired
    protected AbstractMapper<D, E> mapper;

    @Override
    public D create(D d) {
        E e = mapper.toEntity(d);
        super.save(e);
        return mapper.toDto(e);
    }

    @Override
    public D get(Serializable id) {
        E e = super.getById(id);
        return mapper.toDto(e);
    }

    @Override
    public boolean update(D d) {
        E e = mapper.toEntity(d);
        return super.updateById(e);
    }

    @Override
    public IPage<D> findPage(D d, int pageNumber, int pageSize) {
        QueryWrapper<E> qw = new QueryWrapper<>(mapper.toEntity(d));
        IPage<E> page = super.baseMapper.selectPage(new Page<>(pageNumber, pageSize), qw);
        return mapper.toDto(page);
    }

    @Override
    public boolean delete(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean delete(Collection<? extends Serializable> ids) {
        return super.removeByIds(ids);
    }
}
