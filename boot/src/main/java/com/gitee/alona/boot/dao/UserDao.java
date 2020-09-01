package com.gitee.alona.boot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.gitee.alona.boot.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 16:54
 */
public interface UserDao extends BaseMapper<User> {
    /**
     * 测试查询集合
     *
     * @param queryWrapper
     * @return
     */
    List<User> findList1(@Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);

}