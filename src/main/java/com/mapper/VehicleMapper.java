package com.mapper;

import com.pojo.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleMapper {

    /**
     * 查询所有
     * @return
     */
    List<Vehicle> selectAll();

    /**
     * 根据id查找
     * @param id
     */
    Vehicle selectById(int id);

    /**
     * 根据id数组查找
     * @param ids
     * @return
     */
    List<Vehicle> selectByIds(int[] ids);

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @param vehicle
     * @return
     */
    List<Vehicle> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("vehicle") Vehicle vehicle);

    /**
     * 查询总数
     * @param vehicle
     * @return
     */
    int selectTotalCountByCondition(@Param("vehicle") Vehicle vehicle);

    /**
     * 添加车辆
     * @param vehicle
     */
    void add(Vehicle vehicle);

    /**
     * 批量出场
     * @param ids
     */
    void exitByIds(@Param("ids") int[] ids);

    /**
     * 批量进场
     * @param ids
     */
    void enterByIds(@Param("ids") int[] ids);
}
