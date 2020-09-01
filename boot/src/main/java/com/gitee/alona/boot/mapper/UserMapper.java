package com.gitee.alona.boot.mapper;

import com.gitee.alona.boot.entity.User;
import com.gitee.alona.boot.service.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 20:32
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<UserDTO, User> {
}
