package com.me.springbootdemo.controller;

import com.me.springbootdemo.entity.Order;
import com.me.springbootdemo.entity.Student;
import com.me.springbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/index")
public class HelloController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    public String test(Model model){
        return "test";
    }

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
    @GetMapping("/students")
    @ResponseBody
    public String getStudents(){
//        List<Student> studentList = studentService.getStudents();
//        for (Student student: studentList) {
//            System.out.println(student);
//        }
        return "good";
    }

    @GetMapping("/echarts")
    public String showEcharts(){
        return "echarts-demo";
    }

    @GetMapping("/echarts/data")
    @ResponseBody
    public List<Order> getEchartsData(){
        Order order1 = new Order("22",1,"333","2019-01-01");
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String times = format1.format(randomDate("2019-01-01", "2020-01-01")).toString();
            int type=(int)(Math.random()*2);
            int num = (int)(Math.random()*100);
            Order order = new Order("0"+i,type,""+num,times);
            orderList.add(order);

            System.out.println(order.toString());
        }
        return orderList;
    }

    /**
     * 获取随机日期
     *
     * @param beginDate
     *            起始日期，格式为：yyyy-MM-dd
     * @param endDate
     *            结束日期，格式为：yyyy-MM-dd
     * @return
     */

    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

}

