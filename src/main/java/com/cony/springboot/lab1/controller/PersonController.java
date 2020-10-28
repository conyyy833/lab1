package com.cony.springboot.lab1.controller;

import com.cony.springboot.lab1.dao.PersonRepository;
import com.cony.springboot.lab1.entity.Person;
import com.cony.springboot.lab1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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



    /**
     * 查询Person的对象集合
     * @return
     */
    @GetMapping("/persons")
    public ResponseEntity personList()
    {
        List<Person> personList = personService.personList();
        if(personList!=null)
        {

            return new ResponseEntity(personList,HttpStatus.OK);
        }
        else
            return new ResponseEntity("error",HttpStatus.NOT_FOUND);

    }

    /**
     * 新增加一个人
     */

    @PostMapping(value = "/persons")
    public ResponseEntity personAdd(@RequestBody Person person) {
        Person person1 = personService.save(person);
        if(person1!=null)
        {
            HttpHeaders headers=new HttpHeaders();
            List<String> value=new ArrayList<>();
            value.add("https://cony-person-lab1.herokuapp.com/persons/"+person1.getId());
            headers.put(HttpHeaders.LOCATION,value);
            return new ResponseEntity(person1,headers,HttpStatus.CREATED);
        }
        else
            return new ResponseEntity("error",HttpStatus.NOT_FOUND);


    }

    /**
     * 查询人
     */
    @GetMapping(value = "/persons/{id}")
    public ResponseEntity personFindOne(@PathVariable("id") Integer id) {
        Person person = personService.findById(id);
        if(person!=null)
        {
            return new ResponseEntity(person,HttpStatus.FOUND);
        }
        else
            return new ResponseEntity("error",HttpStatus.NOT_FOUND);
    }

    /**
     * 更新人的数据
     *  @RequestParam("name") String name,
     *                                @RequestParam("age") Integer age,
     *                                @RequestParam("address") String address,
     *                                @RequestParam("work") String work
     */
    @PatchMapping (value = "/person/{id}")
    public ResponseEntity personUpdate(@PathVariable("id") Integer id,@RequestBody Person person) {

        Person person1 = personService.personUpdate(id, person);

        if(person1!=null)
        {
            return new ResponseEntity(person1,HttpStatus.CREATED);
        }
        else
            return new ResponseEntity("error",HttpStatus.NOT_FOUND);
    }


    /**
     * 删除人的数据
     */

    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity personDelete(@PathVariable("id") Integer id) {

        Integer integer = personService.myDeleteById(id);

        if(integer!=0)
        {
            return new ResponseEntity(integer,HttpStatus.CREATED);
        }
        else
            return new ResponseEntity("error",HttpStatus.NOT_FOUND);

    }


}

