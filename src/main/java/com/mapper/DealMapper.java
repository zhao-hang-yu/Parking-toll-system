package com.mapper;

import com.pojo.Deal;

import java.util.List;

public interface DealMapper {
    /**
     * 添加交易记录
     * @param deal
     */
    void add(Deal deal);



    /**
     * 查询所有
     * @return
     */
    List<Deal> selectAll();

//    void setMoney();
}
