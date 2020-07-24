package dozer.controller;

import DTO.HelloDTO;
import com.github.dozermapper.core.Mapper;
import domain.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dufugang
 * @create 2018-12-05 5:52 PM
 */
@RestController
@RequestMapping("hello")
public class HelloWorld {

    @Autowired
    private Mapper mapper;

    @GetMapping("/world")
    public HelloDTO hello() throws InterruptedException {

        Hello hello = new Hello();
        hello.setId(1L);
        hello.setName("hello 你好");

        Thread.sleep(500);
        HelloDTO helloDTO = mapper.map(hello, HelloDTO.class);

        return helloDTO;
    }
}
