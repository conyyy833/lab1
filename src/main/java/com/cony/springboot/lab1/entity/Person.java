package com.cony.springboot.lab1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 人的实体类
 * @author Cony
 * 实体层，数据库在项目中的类
 * 主要用于定义与数据库对象应的属性，提供get/set方法,tostring方法,有参无参构造函数。
 */
@Entity //此注解用来表示：当前实体类与数据库中的一个表对应
        //@Table(name = "person")  该数据库表的名字
public class Person{
    @Id //该标注主要用于指定该实例的主键
    @GeneratedValue //用于标注主键的值的生成策略
    private Integer id;

    private String name;

    private Integer age;

    private String address;

    private String work;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, String address, String work) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }
    public Person(String name, Integer age, String address, String work) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }

    public Integer getId() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
