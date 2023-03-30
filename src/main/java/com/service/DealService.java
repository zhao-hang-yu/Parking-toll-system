package com.service;

import com.pojo.Deal;

import java.util.List;

public interface DealService {
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
}
