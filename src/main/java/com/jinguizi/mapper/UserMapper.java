package com.jinguizi.mapper;

import com.jinguizi.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUserByNameAndPassword(User user);
}
