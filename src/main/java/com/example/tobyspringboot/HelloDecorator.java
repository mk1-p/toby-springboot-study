package com.example.tobyspringboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary    // 여러 구현체 중 @Primary 를 통해 우선 주입하겠다 명시
public class HelloDecorator implements HelloService{

    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }


    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }

    @Override
    public Integer countOf(String name) {
        return helloService.countOf(name);
    }
}
