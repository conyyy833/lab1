package com.cony.springboot.lab1.service;


import com.cony.springboot.lab1.dao.PersonRepository;
import com.cony.springboot.lab1.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 事务管理类业务层 业务模块的逻辑应用设计
 * @author Cony
 * 先设计接口，再创建要实现的类，然后在配置文件中进行配置其实现的关联。
 * 接下来就可以在service层调用接口进行业务逻辑应用的处理。
 * 好处：封装Service层的业务逻辑有利于业务逻辑的独立性和重复利用性。
 */
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> insertTwo(){
        Person person1 = new Person();
        person1.setName("Max");
        person1.setAge(30);
        person1.setAddress("Moscow");
        person1.setWork("VRB");
        Person person2 = new Person();
        person2.setName("Lucy");
        person2.setAge(26);
        person1.setAddress("China");
        person1.setWork("ABC");



        List<Person> list=new ArrayList<>();
        list.add(person1);
        list.add(person2);
        List<Person> people = personRepository.saveAll(list);
        return people;
    }

    /**
     * 什么是事务？
     * A100 ->B100
     * A-10   B+10==>A90 B110
     * A-10 断网---
     * A90 B100
     * 开启事务：从第一步开始回滚
     *
     * 查询Person的对象集合
     *
     *
     */
    public List<Person> personList()
    {
        return personRepository.findAll();
    }

    /**
     * 添加
     * @param name
     * @param age
     * @return
     */
    public Person personAdd(@RequestParam("name") String name,
                            @RequestParam("age") Integer age,
                            @RequestParam("address") String address,
                            @RequestParam("work") String work)
    {
        Person person = new Person();
        return personRepository.save(person);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public Person personFindOne( Integer id) {

        return personRepository.findById(id).get();
    }

    /**
     * 更新
     * @param id

     */
    public Person personUpdate(Integer id,Person person) {
        Integer flag = personRepository.personUpdate(id,person);

        if(flag==1)
        {//更新成功
            Person person1 = personRepository.findById(id).get();
            return person1;
        }
        else
            return null;
    }

    /**
     * 删除
     * @param id
     */
    public Integer myDeleteById(Integer id) {
         return personRepository.myDeleteById(id);
    }




    /**
     * 新增加一个人
     */
    public Person save(Person person) {
        return personRepository.save(person);
    }
    /**
     * 查询人
     */
    public Person findById(Integer id) {
        Person person = personRepository.findById(id).get();
        return person;
    }


}
