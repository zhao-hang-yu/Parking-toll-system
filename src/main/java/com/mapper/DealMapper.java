package com.mapper;

import com.pojo.Deal;

public interface DealMapper {
    /**
     * 添加交易记录
     * @param deal
     */
    void add(Deal deal);

    void setMoney();
}
