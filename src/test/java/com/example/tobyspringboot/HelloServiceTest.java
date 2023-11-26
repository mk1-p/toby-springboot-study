package com.example.tobyspringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void helloServiceTest() {
        // given
        String name = "TEST";
        SimpleHelloService helloService = new SimpleHelloService();

        // when
        String ret = helloService.sayHello(name);

        // then
        Assertions.assertThat(ret).isEqualTo("hello TEST");
    }

    @Test
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        String ret = helloDecorator.sayHello("TEST");
        Assertions.assertThat(ret).isEqualTo("*TEST*");

    }

}
