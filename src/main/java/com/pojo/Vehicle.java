package com.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle {
    private Integer id;
    private String carNumber;
    private String phoneNumber;
    //车辆类型 0小型车1中型车2大型车
    private Integer carType;
    //状态 0不在停车场1在停车场
    private Integer state;
    private Integer stopNumber;
    private String remark;

    private Date inTime;

    public Vehicle() {
    }

    public Vehicle(Integer id, String carNumber, String phoneNumber, Integer carType, Integer state, Integer stopNumber, String remark) {
        this.id = id;
        this.carNumber = carNumber;
        this.phoneNumber = phoneNumber;
        this.carType = carType;
        this.state = state;
        this.stopNumber = stopNumber;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(Integer stopNumber) {
        this.stopNumber = stopNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getCarTypeStr() {
        if(carType == null) {
            return "未知";
        }
        if(carType == 0) {
            return "小型车";
        }
        if(carType == 1) {
            return "中型车";
        }
        return "大型车";
    }

    public String getStateStr() {
        if(state == null) {
            return "未知";
        }
        return state == 0 ? "场外" : "场内";
    }

    public String getRemarkStr() {
        if(remark == null) {
            return "无";
        }
        return remark;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", carType=" + carType +
                ", state=" + state +
                ", stopNumber=" + stopNumber +
                ", remark='" + remark + '\'' +
                '}';
    }
}
