package com.cony.springboot.lab1.controller;

import com.cony.springboot.lab1.dao.PersonRepository;
import com.cony.springboot.lab1.entity.CommonResult;
import com.cony.springboot.lab1.entity.Person;
import com.cony.springboot.lab1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 控制层 控制业务逻辑
 * @author Cony
 * controller层主要调用Service层里面的接口控制具体的业务流程
 */

@RestController
public class PersonController {

    @Autowired
    public PersonRepository personRepository;

    @Autowired
    public PersonService personService;

    @GetMapping("/")
    public List<Person> init()
    {
       return personService.insertTwo();
    }

    /**
     * 查询Person的对象集合
     * @return
     */
    @GetMapping("/persons")
    public List<Person> personList()
    {
        List<Person> people = personService.personList();

        return people;

    }

    /**
     * 新增加一个人
     */

    @PostMapping(value = "/person")
    public CommonResult personAdd(@RequestBody Person person) {
        Person person1 = personService.save(person);
        if(person1!=null)
        {
            return new CommonResult(HttpStatus.CREATED,person1);
        }
        else
            return new CommonResult(HttpStatus.NOT_FOUND,null);


    }

    /**
     * 查询人
     */
    @GetMapping(value = "/persons/{id}")
    public CommonResult personFindOne(@PathVariable("id") Integer id) {
        Person person = personService.findById(id);
        if(person!=null)
        {
            return new CommonResult(HttpStatus.FOUND,person);
        }
        else
            return new CommonResult(HttpStatus.NOT_FOUND,null);
    }

    /**
     * 更新人的数据
     *  @RequestParam("name") String name,
     *                                @RequestParam("age") Integer age,
     *                                @RequestParam("address") String address,
     *                                @RequestParam("work") String work
     */
    @PatchMapping (value = "/person/{id}")
    public Person personUpdate(@PathVariable("id") Integer id,@RequestBody Person person) {

        return personService.personUpdate(id,person);
    }


    /**
     * 删除人的数据
     */

    @DeleteMapping(value = "/person/{id}")
    public Integer personDelete(@PathVariable("id") Integer id) {

        return personService.myDeleteById(id);
    }


//    /**
//     * 通过id查询人的信息列表
//     */
//    @GetMapping(value = "/person/{id}")
//    public Person findById(@PathVariable("id") Integer id) {
//
//        return personService.findById(id);
//    }



}

