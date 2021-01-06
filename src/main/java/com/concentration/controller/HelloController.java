package com.concentration.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description HelloSpringBoot
 * @Author zhaoxu
 * @Date 2019/10/14 10:35
 * @Version 1.0
 **/
//@RestController equals @ResponseBody + @Controller
@RestController
public class HelloController {

    @GetMapping("/hello")
        public String hello () {
        return "Hello springboot!";
    }
}
