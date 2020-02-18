package com.me.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(Model model){
//        Student student = new Student("11","name");
//        model.addAttribute("student",student);
        return "hello";
    }
}
