package com.example.tobyspringboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {
    private final HelloRepository helloRepository;

    public SimpleHelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello(String name) {
        this.helloRepository.increaseCount(name);
        return "hello "+name;
    }

    @Override
    public Integer countOf(String name) {
        return helloRepository.countOf(name);
    }

}
