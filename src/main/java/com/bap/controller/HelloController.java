package com.bap.controller;

import com.bap.Mapper.StudentMapper;
import com.bap.entry.Student;
import com.bap.entry.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName HelloController
 * @Author lyd
 * @Date $ $
 * @Vesion 1.0
 * @Description 第一个api 或者 hello api
 **/
//@RestController
@Controller   //获取视图 jsp、html
public class HelloController {
    /*@Value("${name}")
    private String name;
    @Value("${age}")
    private String age;*/
    @Autowired
    private Student stu;

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/hello")
    public String hello(){
//        return "{"+"code:"+200+",data:"+"hello spring boot!!!"+"}";
        /**
         * name: zs
         * age: 18
         */
//        return name+":"+age;
        /**
         *  student:
         *   name: zs
         *   age: 18
         *   sex: 1
         */
        return stu.getName()+":"+stu.getAge()+":"+stu.getSex();
    }

    @RequestMapping("/hello1")
    public Student hello1(){
        return stu;
    }

    //主要是展示时间
    @RequestMapping("/hello2")
    public String hello2(Model model){
        model.addAttribute("now",DateFormat.getDateInstance().format(new Date()));
        return "hello";
    }


    @RequestMapping("/listStudent")
    public String listStudent(Model model){
        List<StudentInfo> ls = studentMapper.findAll();
        model.addAttribute("students",ls);
        return "listStudent";
    }
}