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

    public Person() {
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
