package com.me.springbootdemo.entity;

import java.io.Serializable;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author tianhongce
 * @Date 2020/2/17 20:08
 **/
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    private String teacherId;
    private String teacherName;

    public Teacher() {
    }

    public Teacher(String teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
