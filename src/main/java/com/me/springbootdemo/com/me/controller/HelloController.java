package com.me.springbootdemo.com.me.controller;

import com.me.springbootdemo.com.me.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/index")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(Model model){
        Student student = new Student("11","name");
        model.addAttribute("student",student);
        return "hello";
    }
}
