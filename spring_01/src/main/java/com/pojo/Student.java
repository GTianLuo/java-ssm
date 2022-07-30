package com.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Student implements Person{

    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private Clazz clazz;

    //private String[] hobbies;

    private Map<String,String> hobbies;

    public Student(Integer id, String name, Integer age, String gender) {
        System.out.println("有参构造执行！！！");
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer id, String name, Integer age, String gender, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }



    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student() {
        System.out.println("无参构造执行！！！");
    }


    public Integer getId() {
        System.out.println("getId()执行!!!");
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Map<String, String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", clazz=" + clazz +
                ", hobbies=" + hobbies +
                '}';
    }
}
