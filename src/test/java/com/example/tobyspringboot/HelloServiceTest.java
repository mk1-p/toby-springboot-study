package com.example.tobyspringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloServiceTest {

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

    @Test
    void helloServiceTest() {
        // given
        String name = "TEST";
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

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
