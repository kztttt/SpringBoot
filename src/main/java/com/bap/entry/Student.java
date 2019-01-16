package com.bap.entry;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Student
 * @Author lyd
 * @Date $ $
 * @Vesion 1.0
 * @Description 学生实体类
 **/
@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    private String name;

    private String age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}