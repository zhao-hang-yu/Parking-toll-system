package com.service;

import com.pojo.PageBean;
import com.pojo.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleService {
    /**
     * 查询所有
     * @return
     */
    List<Vehicle> selectAll();

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param vehicle
     * @return
     */
    PageBean<Vehicle> selectByPageAndCondition(int currentPage, int pageSize, Vehicle vehicle);

    /**
     * 添加
     * @param vehicle
     */
    void add(Vehicle vehicle);

    /**
     * 出场
     * @param ids
     */
    void exitByIds(int[] ids);

    /**
     * 进场
     * @param ids
     */
    void enterByIds(int[] ids);
}
