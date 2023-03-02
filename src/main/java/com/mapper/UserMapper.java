package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 根据id和password查找
     * @param id
     * @param password
     * @return
     */
    User selectByIdAndPassword(@Param("id") String id, @Param("password") String password);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    User selectById(@Param("id") String id);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

}
