package com.example.tobyspringboot;

import org.springframework.stereotype.Component;

@MyComponent
public class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }

}
