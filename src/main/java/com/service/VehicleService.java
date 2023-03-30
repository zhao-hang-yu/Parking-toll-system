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
     * 根据id查找
     * @param id
     * @return
     */
    Vehicle selectById(int id);

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
     * 单出
     * @param id
     */
    void exit(int id);

    /**
     * 进场
     * @param ids
     */
    void enterByIds(int[] ids);

    /**
     * 单入
     * @param id
     */
    void enter(int id);

    /**
     * 更新
     * @param vehicle
     */
    void update(Vehicle vehicle);

    /**
     * 修改进入时间
     * @param id
     */
    void updateInTime(int id);

//    /**
//     * 增加停车次数
//     * @param id
//     */
//    void addStopNumber(int id);
}
