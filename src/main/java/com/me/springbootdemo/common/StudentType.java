package com.me.springbootdemo.common;

/**
 * @author tianhongce
 * @version 1.0
 * @date 2020/2/20 21:14
 */
public enum StudentType {
    Bachelor ("学士", 0),
    Master ("硕士", 1),
    Doctor ("博士", 2);

    private String studentType;
    private int i;

    StudentType(String studentType, int i) {
        this.studentType=studentType;
        this.i=i;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "StudentType{" +
                "studentType='" + studentType + '\'' +
                ", i=" + i +
                '}';
    }
}
