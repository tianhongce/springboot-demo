package com.me.springbootdemo.controller;

import com.me.springbootdemo.entity.Student;
import com.me.springbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/index")
public class HelloController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    public String sayHello(Model model){
//        Student student = new Student("11","name");
        Student student = new Student();
        student.setAge(3);
        student.setId("21");
        student.setName("ba");
        model.addAttribute("student",student);
        // TODO: 测试document.ready()前端
        return "hello";
    }
    @GetMapping("students")
    @ResponseBody
    public String getStudents(){
        List<Student> studentList = studentService.getStudents();
        for (Student student: studentList) {
            System.out.println(student);
        }
        return "good";
    }
}
