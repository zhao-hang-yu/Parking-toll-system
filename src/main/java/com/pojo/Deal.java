package com.pojo;

import java.util.Date;

public class Deal extends Vehicle{
    private Date outTime;
    private float money;

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "outTime=" + outTime +
                '}';
    }
}
