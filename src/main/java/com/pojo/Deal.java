package com.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deal extends Vehicle implements Price{
    private Date outTime;
    private float money;

    public Deal() {
    }

    public Deal(Integer id, String carNumber, String phoneNumber, Integer carType, Integer state, String remark) {
        super(id, carNumber, phoneNumber, carType, state, remark);
        outTime = new Date();
    }

    public Deal(Vehicle v) {
        super(v.getId(), v.getCarNumber(), v.getPhoneNumber(), v.getCarType(), v.getState(), v.getRemark(), v.inTime);
        outTime = new Date();
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void calculateMoney() {
        if(outTime.getTime() < inTime.getTime()) {
            return;
        }
        long h = (outTime.getTime() - inTime.getTime()) / 1000 / 60 / 60;
        if(h < 1) {
            money = 0;
        }
        switch (carType) {
            case 0: money = h * priceState0;
                break;
            case 1: money = h * priceState1;
                break;
            case 2: money = h * priceState2;
                break;
        }
    }

    public String getOutTimeStr() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(outTime);
    }

    @Override
    public String toString() {
        return "Deal{" +
                "outTime=" + outTime +
                ", money=" + money +
                ", id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", carType=" + carType +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", inTime=" + inTime +
                '}';
    }
}
