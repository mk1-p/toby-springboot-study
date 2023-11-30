package com.example.tobyspringboot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

// @Controller와 차이점은
// @ResponseBody 가 메타 어노테이션으로 붙어 있어
// view를 기본 반환타입으로 찾이 않게 된다.
@RestController
public class HelloController {
    private final HelloService helloService;

    // 예전 Spring에서는 XML 로 어떤 클래스가 구현체인지 지정을 해줬어야하지만
    // 현재는 Spring Container가 등록된 Bean 객체를 찾아 자동으로 입력되게 되었음
    // Bean 등록은 사용할 구현체 클래스를 등록해주면 된다.
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    // Spring 으로 반환할 경우 기본적으로 view를 찾게된다
    // ResponseBody를 붙여줌으로써 String 타입을 반환한다는 의미를 부여해준다.
    // RestController 를 사용하면 자동으로 ResponseBody 형태로 인식하게 되므로 별도로 작성해줄 필요가 없다.
    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String getCount(String name) {
        return name + " : " + helloService.countOf(name);
    }

}
