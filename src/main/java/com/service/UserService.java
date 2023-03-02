package com.service;

import com.pojo.User;

public interface UserService {
    /**
     * 根据id和password查找
     * @param id
     * @param password
     * @return
     */
    User selectByIdAndPassword(String id, String password);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    User selectById(String id);

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
