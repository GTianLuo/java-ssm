package com.mappers;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    List<User> selectUserList();

    void deleteUser(@Param("id") Integer id);

    void updateUser(@Param("id") Integer id);
}
