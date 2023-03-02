package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User selectByIdAndPassword(String id, String password) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.selectByIdAndPassword(id, password);
        //释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public User selectById(String id) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.selectById(id);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public void add(User user) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        mapper.add(user);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void update(User user) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        mapper.update(user);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


}
