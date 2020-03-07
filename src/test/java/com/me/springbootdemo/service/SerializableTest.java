package com.me.springbootdemo.service;
/**
 * @author tianhongce
 * @date 2020/2/24 22:07
 * @version 1.0
 */

import com.alibaba.fastjson.JSONObject;
import com.me.springbootdemo.entity.Student;
import com.me.springbootdemo.entity.Teacher;
import org.junit.Test;

import java.io.*;

/**
 * @ClassName SerializableTest
 * @Description TODO
 * @Author tianhongce
 * @Date 2020/2/24 22:07
 **/
public class SerializableTest {
    @Test
    public void serial() throws Exception{
        Student student = new Student("41","fa",41);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(student);
        oos.close();

    }

    @Test
    public void deSerial() throws Exception{
        //反序列化
        File file = new File("template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student student = (Student) ois.readObject();
        System.out.println(student.toString());
    }

    @Test
    public void jsonSerial()throws Exception{
        Student student = new Student("41","fa",43);
        System.out.println(student.toString());
        String jsonString = JSONObject.toJSONString(student);
        System.out.println(jsonString);

        Teacher teacher = new Teacher("666","yyy");
        System.out.println(teacher.toString());
        String teacherJson = JSONObject.toJSONString(teacher);
        System.out.println(teacherJson);


    }

    @Test
    public void jsonDeSerial()throws Exception{
        Student student=JSONObject.parseObject("{age:\"41\",\"id\":\"41\",\"name\":\"fa\"}",Student.class);

        System.out.println(student);
    }
}
