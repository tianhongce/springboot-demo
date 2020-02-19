package com.me.springbootdemo.service.impl;
/**
 * @author tianhongce
 * @date 2020/2/18 21:04
 * @version 1.0
 */

import com.me.springbootdemo.dao.StudentMapper;
import com.me.springbootdemo.entity.Student;
import com.me.springbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author tianhongce
 * @Date 2020/2/18 21:04
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentMapper.selectAll();
    }
}
