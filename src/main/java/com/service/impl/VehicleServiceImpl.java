package com.service.impl;

import com.mapper.UserMapper;
import com.mapper.VehicleMapper;
import com.pojo.PageBean;
import com.pojo.Vehicle;
import com.service.VehicleService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Vehicle> selectAll() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        VehicleMapper mapper = sqlSession.getMapper(VehicleMapper.class);
        //调用方法
        List<Vehicle> list = mapper.selectAll();
        System.out.println("list :" + list);
        //释放资源
        sqlSession.close();
        return list;
    }

    @Override
    public PageBean<Vehicle> selectByPageAndCondition(int currentPage, int pageSize, Vehicle vehicle) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        VehicleMapper mapper = sqlSession.getMapper(VehicleMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        //处理模糊查询参数
        String carNumber = vehicle.getCarNumber();
        if(carNumber != null && carNumber.length() > 0) {
            vehicle.setCarNumber("%" + carNumber + "%");
        }
        String phoneNumber = vehicle.getPhoneNumber();
        if(phoneNumber != null && phoneNumber.length() > 0) {
            vehicle.setPhoneNumber("%" + phoneNumber + "%");
        }
        //调用方法
        List<Vehicle> rows = mapper.selectByPageAndCondition(begin, size, vehicle);
        int totalCount =mapper.selectTotalCountByCondition(vehicle);
        //封装PageBean对象
        PageBean<Vehicle>pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        //释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void add(Vehicle vehicle) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        VehicleMapper mapper = sqlSession.getMapper(VehicleMapper.class);
        //调用方法
        mapper.add(vehicle);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void exitByIds(int[] ids) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        VehicleMapper mapper = sqlSession.getMapper(VehicleMapper.class);
        //调用方法
        mapper.exitByIds(ids);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void enterByIds(int[] ids) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper对象
        VehicleMapper mapper = sqlSession.getMapper(VehicleMapper.class);
        //调用方法
        mapper.enterByIds(ids);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


}
