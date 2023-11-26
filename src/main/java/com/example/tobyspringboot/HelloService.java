package com.example.tobyspringboot;


import org.springframework.stereotype.Service;

@Service
public interface  HelloService {
    String sayHello(String name);
}
