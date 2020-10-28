package com.cony.springboot.lab1;

import com.cony.springboot.lab1.entity.CommonResult;
import com.cony.springboot.lab1.entity.Person;
import com.cony.springboot.lab1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class Lab1ApplicationTests {
        @MockBean
        PersonService personService;
        @Autowired
        MockMvc mockMvc;
        @Test
        public void personFindOne() throws Exception {
            Person person=new Person(1,"cony",12,"Moscow","VRB");

            when(personService.findById(1)).thenReturn(person);
            mockMvc.perform(get("/persons/{id}",1))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();

        }
        @Test
        public void personList() throws Exception {
            List<Person> list=new ArrayList<>();
            Person person=new Person(1,"cony",12,"Moscow","VRB");
            list.add(person);

            when(personService.personList()).thenReturn(list);
            mockMvc.perform(get("/persons"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();

        }
        @Test
        public void personAdd() throws Exception {
            Person person=new Person(1,"cony",12,"Moscow","VRB");

            when(personService.save("cony",12,"Moscow","VRB")).thenReturn(person);
            mockMvc.perform(post("/person")
                    .param("name","cony")
                    .param("age","12")
                    .param("address","Moscow")
                    .param("work","VRB"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
        }

        @Test
        public void personUpdate() throws Exception {
            Person person=new Person(1,"cony",12,"Moscow","VRB");

            when(personService.personUpdate(1,"cony",12,"Moscow","VRB")).thenReturn(person);
            mockMvc.perform(patch("/person/{id}",1)
                    .param("name","cony")
                    .param("age","12")
                    .param("address","Moscow")
                    .param("work","VRB"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
        }
        @Test
        public void personDelete() throws Exception {
            Person person=new Person(1,"cony",12,"Moscow","VRB");

            when(personService.myDeleteById(1)).thenReturn(1);
            mockMvc.perform(delete("/person/{id}",1))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
        }

}
