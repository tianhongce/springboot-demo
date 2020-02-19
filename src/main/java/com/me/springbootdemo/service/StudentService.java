package com.me.springbootdemo.service;

import com.me.springbootdemo.entity.Student;

import java.util.List;

/**
 * @author tianhongce
 * @version 1.0
 * @date 2020/2/18 21:02
 */
public interface StudentService {
    public int addStudent(Student student);

    public List<Student> getStudents();
}
