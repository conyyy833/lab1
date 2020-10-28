package com.cony.springboot.lab1.dao;

import com.cony.springboot.lab1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 持久层，主要与数据库交互
 * @author Cony
 * DAO层首先会创建Dao接口，之后可以在配置文件中定义该接口的实现类；
 * 之后就可以在模块中调用Dao的接口进行数据业务的处理，
 * 而不用关注此接口的具体实现类是哪一个类，Dao层的数据源和数据库连接的参数都是在配置文件中进行配置的。
 */


@Repository //PersonRepository被@Repository注解，通过继承拥有了对数据进行CRUD的方法，包括findAll()
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //通过年龄来查询
    Optional<Person> findById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update person set name=:name,age=:age,address=:address,work=:work where id=:id",nativeQuery = true)
    Integer personUpdate(@Param("id") Integer id,
                         @Param("name")String name,
                         @Param("age")Integer age,
                         @Param("address")String address,
                         @Param("work")String work);

    @Transactional
    @Modifying
    @Query(value = "delete from person where id=?1",nativeQuery = true)
    Integer myDeleteById(Integer id);
}

