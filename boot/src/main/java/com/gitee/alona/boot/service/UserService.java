package com.gitee.alona.boot.service;

import com.gitee.alona.boot.entity.User;
import com.gitee.alona.boot.mapper.UserMapper;
import com.gitee.alona.boot.service.dto.UserDTO;

/**
 * user 服务类
 *
 * @author 孤胆枪手
 */
public interface UserService extends BaseService<UserDTO, User, UserMapper> {

}
