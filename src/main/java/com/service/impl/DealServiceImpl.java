package com.service.impl;

import com.mapper.DealMapper;
import com.pojo.Deal;
import com.service.DealService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DealServiceImpl implements DealService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void add(Deal deal) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        DealMapper mapper = sqlSession.getMapper(DealMapper.class);
        //调用方法
        mapper.add(deal);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public List<Deal> selectAll() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        DealMapper mapper = sqlSession.getMapper(DealMapper.class);
        //调用方法
        List<Deal> deals = mapper.selectAll();
        //释放资源
        sqlSession.close();
        return deals;
    }
}
