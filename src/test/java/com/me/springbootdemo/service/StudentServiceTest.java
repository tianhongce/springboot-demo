package com.me.springbootdemo.service;

import com.me.springbootdemo.entity.Student;
import com.me.springbootdemo.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName StudentServiceTest
 * @Description TODO
 * @Author tianhongce
 * @Date 2020/2/18 21:09
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentServiceTest {

    private StudentService studentService = new StudentServiceImpl();

    @Test
    public void testAddStudent(){
        Student student = new Student();
        student.setName("ag");
        student.setId("17");
        student.setAge(22);
        studentService.addStudent(student);
    }
}
