package com.example.tobyspringboot;

import java.util.Objects;

public class HelloController {
    private final HelloService helloService;

    // 예전 Spring에서는 XML 로 어떤 클래스가 구현체인지 지정을 해줬어야하지만
    // 현재는 Spring Container가 등록된 Bean 객체를 찾아 자동으로 입력되게 되었음
    // Bean 등록은 사용할 구현체 클래스를 등록해주면 된다.
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {

        return helloService.sayHello(Objects.requireNonNull(name));
    }

}
