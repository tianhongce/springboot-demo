package com.me.springbootdemo.entity;
/**
 * @author tianhongce
 * @date 2020/2/26 0:23
 * @version 1.0
 */

/**
 * @ClassName Order
 * @Description TODO
 * @Author tianhongce
 * @Date 2020/2/26 0:23
 **/
public class Order {
    String OrId;
    int OrType;
    String OrNum;
    String OrTime;

    public Order(String orId, int orType, String orNum, String orTime) {
        OrId = orId;
        OrType = orType;
        OrNum = orNum;
        OrTime = orTime;
    }

    public String getOrId() {
        return OrId;
    }

    public void setOrId(String orId) {
        OrId = orId;
    }

    public int getOrType() {
        return OrType;
    }

    public void setOrType(int orType) {
        OrType = orType;
    }

    public String getOrNum() {
        return OrNum;
    }

    public void setOrNum(String orNum) {
        OrNum = orNum;
    }

    public String getOrTime() {
        return OrTime;
    }

    public void setOrTime(String orTime) {
        OrTime = orTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrId='" + OrId + '\'' +
                ", OrType=" + OrType +
                ", OrNum='" + OrNum + '\'' +
                ", OrTime='" + OrTime + '\'' +
                '}';
    }
}
